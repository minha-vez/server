package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Convenio;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvenioRequestDto {

    private String nome;

    public static Convenio toEntity(ConvenioRequestDto convenioRequestDto) {
        return Convenio.builder()
                .nome(convenioRequestDto.getNome())
                .build();
    }
}
