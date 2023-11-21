package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Ticket;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequestDto {

    private LocalTime horaEntrada;

    public static Ticket toEntity(TicketRequestDto ticketRequestDto) {
        return Ticket.builder()
                .horaEntrada(ticketRequestDto.getHoraEntrada()).build();


    }


}
