package br.com.carrancas.start.minhavez.exception.handler;

import br.com.carrancas.start.minhavez.exception.CnpjExistenteException;
import br.com.carrancas.start.minhavez.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CnpjExistenteException.class)
    private ResponseEntity<ExceptionDetails> handlerNotFoundException(CnpjExistenteException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .status(ex.getStatusCode().value())
                .titulo("Bad Request Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
