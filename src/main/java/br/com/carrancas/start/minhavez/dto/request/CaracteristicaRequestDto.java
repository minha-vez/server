package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Especialidade;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaracteristicaRequestDto {

    private String descricao;

    public static Especialidade toEntity(CaracteristicaRequestDto caracteristicaDto) {
        return Especialidade.builder()
                .descricao(caracteristicaDto.getDescricao())
                .build();

    }

}
