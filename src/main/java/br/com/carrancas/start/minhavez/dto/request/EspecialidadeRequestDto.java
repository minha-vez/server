package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Especialidade;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeRequestDto {

    private String descricao;

    public static Especialidade toEntity(EspecialidadeRequestDto especialidadeDto) {
        return Especialidade.builder()
                .descricao(especialidadeDto.getDescricao())
                .build();

    }

}
