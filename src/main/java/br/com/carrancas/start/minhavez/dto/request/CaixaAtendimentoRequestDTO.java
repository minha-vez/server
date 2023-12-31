package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.CaixaAtendimento;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaixaAtendimentoRequestDTO {
    private String nomeAtendente;
    private boolean status;

    public static CaixaAtendimento toEntity(CaixaAtendimentoRequestDTO caixaAtendimentoDTO) {
        return CaixaAtendimento.builder()
                .nomeCaixa(caixaAtendimentoDTO.getNomeAtendente())
                .status(caixaAtendimentoDTO.isStatus())
                .build();
    }
}
