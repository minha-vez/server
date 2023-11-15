package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Convenio;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvenioResponseDto {

    private String nome;

    public static ConvenioResponseDto toDto(Convenio convenio) {
        return ConvenioResponseDto.builder()
                .nome(convenio.getNome())
                .build();
    }
}
