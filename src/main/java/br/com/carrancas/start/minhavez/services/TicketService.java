package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.config.JwtService;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.entities.Fila;
import br.com.carrancas.start.minhavez.entities.Pessoa;
import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.eums.Status;
import br.com.carrancas.start.minhavez.repositories.TicketRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final FilaService filaService;
    private final PessoaService pessoaService;
    private final JwtService jwtService;

    public TicketResponseDto criar(int filaId) {
        String userEmail = getUserEmail();
        Ticket ticket = new Ticket();
        Pessoa pessoa = pessoaService.getPessoa(userEmail);
        Fila fila = filaService.getFila(filaId);
        ticket.setFila(fila);
        ticket.setPessoa(pessoa);
        ordemTicket(ticket, fila);
        //TODO fazer validação para que pessoa nao entre na fila 2x...
        ticketRepository.save(ticket);
        return TicketResponseDto.toDto(ticket);
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
                    .findFirstByFilaEmpresaIdOrderByDataCriacaoDesc(fila.getEmpresa().getId())
                    .orElse(null);

            if (ultimoTicket != null) {
                int ultimaOrdem = ultimoTicket.getOrdem();
                ordem = ultimaOrdem + 1;
            }
            ticket.setOrdem(ordem);
        }
    }

    public void cancelarTicket(int ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(()-> new RuntimeException("Ticket não encontrado"));
        if (ticket.getStatusAtendimento().equals(Status.ESPERA))
            ticket.setStatusAtendimento(Status.CANCELADO);
    }


    public List<TicketResponseDto> listarTicketByFila(int filaId) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getFila().getId() == filaId)
                .map(ticket -> TicketResponseDto.toDto(ticket))
                .collect(Collectors.toList());
    }

}
