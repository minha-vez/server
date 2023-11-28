package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.config.JwtService;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseRelatorioDTO;
import br.com.carrancas.start.minhavez.entities.Cliente;
import br.com.carrancas.start.minhavez.entities.Fila;
import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.eums.Status;
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
        Ticket ticket = new Ticket();
        Cliente cliente = clienteService.getPessoa(userEmail);
        Fila fila = filaService.getFila(filaId);
        ticket.setFila(fila);
        ticket.setCliente(cliente);
        ordemTicket(ticket, fila);
        //TODO fazer validação para que pessoa nao entre na fila 2x...
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
        }
    }

    public void atenderTicket(int ticketId) {
        Ticket ticket = getTicket(ticketId);
        if (ticket.getStatusAtendimento().equals(Status.ESPERA)) {
            ticket.setStatusAtendimento(Status.ATENDIMENTO);
            ticketRepository.save(ticket);
        }
    }

    public void finalizarTicket(int ticketId) {
        Ticket ticket = getTicket(ticketId);
        if(ticket.getStatusAtendimento().equals(Status.ATENDIMENTO)){
            ticket.setStatusAtendimento(Status.FINALIZADO);
            ticket.setHoraEncerramento(LocalTime.now());
            ticketRepository.save(ticket);
        }
    }

    public TicketResponseRelatorioDTO mediaAtendimentoPorDia(int filaId){
        List<Ticket> tickets = listarTicketEntityByFila(filaId);
        int qntTickets = tickets.size();

        long somaAtendimentoEmSegundos = tickets.stream()
                .mapToLong(ticket -> {
                    LocalTime horaEntrada = ticket.getHoraEntrada();
                    LocalTime horaEncerramento = ticket.getHoraEncerramento();

                    return Duration.between(horaEntrada, horaEncerramento).getSeconds();
                })
                .sum();

        long mediaAtendimentoEmSegundos = somaAtendimentoEmSegundos / qntTickets;
        LocalTime mediaAtendimento = LocalTime.ofSecondOfDay(mediaAtendimentoEmSegundos);

        return TicketResponseRelatorioDTO.builder()
                .qntTickets(qntTickets)
                .mediaAtendimento(mediaAtendimento)
                .build();
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
