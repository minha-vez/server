package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pessoa/{pessoaId}/fila/{filaId}")
    public TicketResponseDto criar(@PathVariable("pessoaId") int pessoaId, @PathVariable("filaId") int filaId) {
        return ticketService.criar(pessoaId, filaId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TicketResponseDto> listarTickets() {
        return ticketService.listarTicket();
    }

}
