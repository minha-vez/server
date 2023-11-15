package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Fila;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilaRequestDto {

    private LocalDate data;

    public static Fila toEntity(FilaRequestDto filaRequestDto) {
        return Fila.builder()
                .data(filaRequestDto.getData()).build();

    }
}
