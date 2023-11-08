package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Caracteristica;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaracteristicaRequestDto {

    private String descricao;

    public static Caracteristica toEntity(CaracteristicaRequestDto caracteristicaDto) {
        return Caracteristica.builder()
                .descricao(caracteristicaDto.getDescricao())
                .build();

    }

}
