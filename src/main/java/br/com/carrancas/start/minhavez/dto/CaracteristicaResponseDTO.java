package br.com.carrancas.start.minhavez.dto;

import br.com.carrancas.start.minhavez.entities.Caracteristica;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaracteristicaResponseDTO {
    private String descricao;

    public static CaracteristicaResponseDTO toDto(Caracteristica caracteristica) {
        return CaracteristicaResponseDTO.builder()
                .descricao(caracteristica.getDescricao())
                .build();
    }
}
