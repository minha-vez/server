package br.com.carrancas.start.minhavez.exception.handler.role;

import br.com.carrancas.start.minhavez.exception.ExceptionDetails;
import br.com.carrancas.start.minhavez.exception.role.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RoleRestExceptionHandler {

    @ExceptionHandler(RoleNotFoundException.class)
    private ResponseEntity<ExceptionDetails> handlerRoleNotFoundException(RoleNotFoundException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .titulo("Not Found Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }
}
