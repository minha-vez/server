package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.config.JwtService;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseRelatorioDTO;
import br.com.carrancas.start.minhavez.entities.Cliente;
import br.com.carrancas.start.minhavez.entities.Fila;
import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.enums.Status;
import br.com.carrancas.start.minhavez.exception.cliente.ClienteEmFilaException;
import br.com.carrancas.start.minhavez.exception.ticket.TicketStatusException;
import br.com.carrancas.start.minhavez.repositories.TicketRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final FilaService filaService;
    private final ClienteService clienteService;
    private final JwtService jwtService;

    public TicketResponseDto criar(int filaId) {
        String userEmail = getUserEmail();
        Cliente cliente = clienteService.getPessoa(userEmail);
        boolean possuiTicketsEspera = ticketRepository.existsByClienteAndStatusIn(
                cliente,
                Arrays.asList(Status.ESPERA));
        boolean possuiTickets = ticketRepository.existsByCliente(cliente);

        if(possuiTicketsEspera){
            throw new ClienteEmFilaException();
        }
        Ticket ticket = new Ticket();
        Fila fila = filaService.getFila(filaId);
        ticket.setFila(fila);
        ticket.setCliente(cliente);
        ordemTicket(ticket, fila);
        ticketRepository.save(ticket);
        return TicketResponseDto.toDto(ticket);
    }

    public List<TicketResponseDto> listarTicketByFila(int filaId) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getFila().getId() == filaId)
                .map(TicketResponseDto::toDto)
                .collect(Collectors.toList());
    }

    public void cancelarTicket(int ticketId) {
        Ticket ticket = getTicket(ticketId);
        if (ticket.getStatusAtendimento().equals(Status.ESPERA)) {
            ticket.setStatusAtendimento(Status.CANCELADO);
            ticketRepository.save(ticket);
            return;
        }
        throw new TicketStatusException("O ticket não está no status adequado para cancelamento.");
    }

    public Ticket atenderTicket(int ticketId) {
        Ticket ticket = getTicket(ticketId);
        if (ticket.getStatusAtendimento().equals(Status.ESPERA)) {
            ticket.setStatusAtendimento(Status.ATENDIMENTO);
            ticketRepository.save(ticket);
            return ticket;
        }
        throw new TicketStatusException("O ticket não está no status adequado para atendimento.");
    }

    public void finalizarTicket(int ticketId) {
        Ticket ticket = getTicket(ticketId);
        if(ticket.getStatusAtendimento().equals(Status.ATENDIMENTO)){
            ticket.setStatusAtendimento(Status.FINALIZADO);
            ticket.setHoraEncerramento(LocalTime.now());
            ticketRepository.save(ticket);
            return;
        }
        throw new TicketStatusException("O ticket não está no status adequado para finalizado.");
    }

    public TicketResponseRelatorioDTO mediaAtendimentoPorDia(int filaId){
        //TODO fazer a validação, se o resultado for zero...
        List<Ticket> tickets = listarTicketEntityByFila(filaId);

        List<Ticket> ticketsFinalizados = filtrarTicketsPorStatus(tickets, Status.FINALIZADO);
        List<Ticket> ticketsCancelados = filtrarTicketsPorStatus(tickets, Status.CANCELADO);

        int qntTicketsFinalizado = ticketsFinalizados.size();
        int qntTicketsCancelado = ticketsCancelados.size();

        long somaAtendimentoEmSegundos = ticketsFinalizados.stream()
                .mapToLong(ticket -> {
                    LocalTime horaEntrada = ticket.getHoraEntrada();
                    LocalTime horaEncerramento = ticket.getHoraEncerramento();

                    return Duration.between(horaEntrada, horaEncerramento).getSeconds();
                })
                .sum();

        long mediaAtendimentoEmSegundos = somaAtendimentoEmSegundos / qntTicketsFinalizado;
        LocalTime mediaAtendimento = LocalTime.ofSecondOfDay(mediaAtendimentoEmSegundos);

        return TicketResponseRelatorioDTO.builder()
                .qntTicketsFinalizados(qntTicketsFinalizado)
                .mediaAtendimento(mediaAtendimento)
                .qntTicketsCancelados(qntTicketsCancelado)
                .build();
    }

    private List<Ticket> filtrarTicketsPorStatus(List<Ticket> tickets, Status status) {
        return tickets.stream()
                .filter(ticket -> ticket.getStatusAtendimento().equals(status))
                .toList();
    }

    private List<Ticket> listarTicketEntityByFila(int filaId) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getFila().getId() == filaId)
                .collect(Collectors.toList());
    }

    private Ticket getTicket(int ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado"));
        return ticket;
    }

    private String getUserEmail() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        final String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        String jwt = bearerToken.substring(7);
        String userEmail = jwtService.extractUsername(jwt);
        return userEmail;
    }

    private void ordemTicket(Ticket ticket, Fila fila) {
        int ordem = 1;
        LocalDate dataAtual = LocalDate.now();

        if (!fila.getData().equals(dataAtual)) {
            //TODO fazer validação, para o usuario nao conseguir entrar na fila do dia anterior...
            ticket.setOrdem(ordem);
        } else {
            Ticket ultimoTicket = ticketRepository
                    .findLastTicketByEmpresaIdAndData(
                            fila.getEmpresa().getId(), dataAtual)
                    .orElse(null);

            if (ultimoTicket != null) {
                int ultimaOrdem = ultimoTicket.getOrdem();
                ordem = ultimaOrdem + 1;
            }
            ticket.setOrdem(ordem);
        }
    }

}
