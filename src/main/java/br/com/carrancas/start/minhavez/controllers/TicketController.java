package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.TicketRequestDto;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/fila/{filaId}")
    @PreAuthorize("hasAnyRole('CLIENTE')")
    public TicketResponseDto criar(@PathVariable("filaId") int filaId) {
        return ticketService.criar(filaId);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<TicketResponseDto> listarTickets() {
        return ticketService.listarTicket();
    }

}
