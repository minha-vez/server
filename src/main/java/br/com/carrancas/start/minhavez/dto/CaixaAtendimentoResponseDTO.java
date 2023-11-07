package br.com.carrancas.start.minhavez.dto;

import br.com.carrancas.start.minhavez.entities.CaixaAtendimento;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaixaAtendimentoResponseDTO {

    private String nomeAtendente;
    private boolean status;

    public  static  CaixaAtendimentoResponseDTO toDTO(CaixaAtendimento caixaAtendimento){
        return CaixaAtendimentoResponseDTO.builder()
                .nomeAtendente(caixaAtendimento.getNomeAtendente())
                .status(caixaAtendimento.isStatus())
                .build();
    }
}