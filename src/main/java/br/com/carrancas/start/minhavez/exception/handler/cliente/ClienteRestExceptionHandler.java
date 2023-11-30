package br.com.carrancas.start.minhavez.exception.handler.cliente;

import br.com.carrancas.start.minhavez.exception.ExceptionDetails;
import br.com.carrancas.start.minhavez.exception.cliente.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ClienteRestExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    private ResponseEntity<ExceptionDetails> handlerRoleNotFoundException(ClienteNotFoundException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .titulo("Not Found Exception, Check a Documentação")
                .status(ex.getStatusCode().value())
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }
}
