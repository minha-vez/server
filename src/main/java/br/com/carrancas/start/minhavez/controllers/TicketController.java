package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.response.TicketResponseDto;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseRelatorioDTO;
import br.com.carrancas.start.minhavez.services.TicketService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    @GetMapping("/fila/{filaId}")
    public List<TicketResponseDto> listarTickets(@PathVariable int filaId) {
        return ticketService.listarTicketByFila(filaId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/ticket/{ticketId}")
    public void cancelarTicket(@PathVariable int ticketId){
        ticketService.cancelarTicket(ticketId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/ticket/atender/{ticketId}")
    public void atenderTicket(@PathVariable int ticketId){
        ticketService.atenderTicket(ticketId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/ticket/finalizar/{ticketId}")
    public void finalizarTicket(@PathVariable int ticketId){
        ticketService.finalizarTicket(ticketId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fila/{filaId}/relatorio")
    public TicketResponseRelatorioDTO mediaAtendimentoPorDia(@PathVariable int filaId){
        return ticketService.mediaAtendimentoPorDia(filaId);
    }
}
