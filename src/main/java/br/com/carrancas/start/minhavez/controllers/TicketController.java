package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.TicketRequestDto;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/pessoa/{pessoaId}/fila/{filaId}")
    public TicketResponseDto criar(int pessoaId, int filaId) {
        return ticketService.criar(pessoaId, filaId);
    }

    @GetMapping
    public List<TicketResponseDto> listarTickets() {
        return ticketService.listarTicket();
    }

}
