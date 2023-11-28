package br.com.carrancas.start.minhavez.dto.response;

import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseRelatorioDTO {

    private int qntTickets;
    private LocalTime mediaAtendimento;
}
