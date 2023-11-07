package br.com.carrancas.start.minhavez.dto;

import br.com.carrancas.start.minhavez.entities.Ticket;
import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {

    private int ordem;
    private LocalTime horaEntrada;


    public static TicketResponseDto toDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .ordem(ticket.getOrdem())
                .horaEntrada(ticket.getHoraEntrada()).build();

    }


}
