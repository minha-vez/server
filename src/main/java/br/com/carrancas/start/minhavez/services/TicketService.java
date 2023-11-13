package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.EmpresaRequestDto;
import br.com.carrancas.start.minhavez.dto.request.TicketRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseDTO;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    public TicketResponseDto criar(TicketRequestDto ticketRequestDto) {
        Ticket ticket = TicketRequestDto.toEntity(ticketRequestDto);
        ticketRepository.save(ticket);
        return TicketResponseDto.toDto(ticket);
    }

    public List<TicketResponseDto> listarTicket(){
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(empresa -> TicketResponseDto.toDto(empresa)).collect(Collectors.toList());
    }

}
