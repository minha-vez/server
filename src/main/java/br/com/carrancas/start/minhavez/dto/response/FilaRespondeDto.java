package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Fila;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilaRespondeDto {

    private LocalDate data;

    public static FilaRespondeDto toDto( Fila fila) {
        return FilaRespondeDto.builder()
                .data(fila.getData()).build();
    }
}
