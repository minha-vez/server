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

    @PostMapping("/criar")
    public TicketResponseDto criar(@RequestBody TicketRequestDto ticketRequestDto) {
        return ticketService.criar(ticketRequestDto);
    }
    @GetMapping
    public List<TicketResponseDto> listarTickets (){
        return ticketService.listarTicket();
    }

}
