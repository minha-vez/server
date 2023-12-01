package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Ticket;
import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseRelatorioDTO {

    private int qntTicketsFinalizados;
    private int qntTicketsCancelados;
    private LocalTime mediaAtendimento;
}
