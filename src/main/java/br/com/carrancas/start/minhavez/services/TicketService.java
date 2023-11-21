package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.entities.Fila;
import br.com.carrancas.start.minhavez.entities.Pessoa;
import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final FilaService filaService;
    private final PessoaService pessoaService;

    public TicketResponseDto criar(int pessoaId, int filaId) {
        Ticket ticket = new Ticket();
        Pessoa pessoa = pessoaService.getPessoa(pessoaId);
        Fila fila = filaService.getFila(filaId);
        ticket.setFila(fila);
        ticket.setPessoa(pessoa);

        int ordem = 1;
        LocalDate dataAtual = LocalDate.now();
        if(!fila.getData().equals(dataAtual)){
            ticket.setOrdem(ordem);
        }else{
            Ticket ultimoTicket =
                    ticketRepository.findFirstByFilaEmpresaIdOrderByDataCriacaoDesc(fila.getEmpresa().getId())
                            .orElseThrow(() -> new RuntimeException("Nenhum ticket registrado no banco de dados"));
            int ultimaOrdem = ultimoTicket.getOrdem();
            ordem = ultimaOrdem + 1;
            ticket.setOrdem(ordem);
        }
        return TicketResponseDto.toDto(ticket);
    }

    public List<TicketResponseDto> listarTicket() {
        return ticketRepository.findAll().stream()
                .map(empresa -> TicketResponseDto.toDto(empresa))
                .collect(Collectors.toList());
    }

}
