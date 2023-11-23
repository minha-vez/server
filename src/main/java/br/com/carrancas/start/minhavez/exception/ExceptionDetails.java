package br.com.carrancas.start.minhavez.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {

    private String titulo;
    private int status;
    private String detalhes;
    private String mensagemDesenvolvedor;
    private LocalDateTime dataHora;

}
