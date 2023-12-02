package br.com.carrancas.start.minhavez.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseTelaDTO {

    private String nome;
    private int ordem;
    private String nomeEstabelecimento;
}
