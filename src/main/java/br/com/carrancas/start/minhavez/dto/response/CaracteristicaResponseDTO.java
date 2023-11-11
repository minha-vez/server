package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Especialidade;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaracteristicaResponseDTO {
    private String descricao;

    public static CaracteristicaResponseDTO toDto(Especialidade especialidade) {
        return CaracteristicaResponseDTO.builder()
                .descricao(especialidade.getDescricao())
                .build();
    }
}
