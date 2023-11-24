package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.services.TicketService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/fila/{filaId}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ADMIN')")
    public TicketResponseDto criar(@PathVariable("filaId") int filaId) {
        return ticketService.criar(filaId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<TicketResponseDto> listarTickets() {
        return ticketService.listarTicket();
    }
}
