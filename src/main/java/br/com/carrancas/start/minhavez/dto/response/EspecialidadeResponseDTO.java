package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Especialidade;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeResponseDTO {
    private String descricao;

    public static EspecialidadeResponseDTO toDto(Especialidade especialidade) {
        return EspecialidadeResponseDTO.builder()
                .descricao(especialidade.getDescricao())
                .build();
    }
}
