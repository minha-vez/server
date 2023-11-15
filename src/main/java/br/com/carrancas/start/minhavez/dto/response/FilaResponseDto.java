package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Fila;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilaResponseDto {

    private LocalDate data;

    public static FilaResponseDto toDto(Fila fila) {
        return FilaResponseDto.builder()
                .data(fila.getData()).build();
    }
}
