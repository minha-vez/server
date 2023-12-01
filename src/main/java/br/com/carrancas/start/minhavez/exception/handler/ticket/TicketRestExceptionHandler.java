package br.com.carrancas.start.minhavez.exception.handler.ticket;

import br.com.carrancas.start.minhavez.exception.ExceptionDetails;
import br.com.carrancas.start.minhavez.exception.role.RoleNotFoundException;
import br.com.carrancas.start.minhavez.exception.ticket.TicketStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TicketRestExceptionHandler {

    @ExceptionHandler(TicketStatusException.class)
    private ResponseEntity<ExceptionDetails> handlerTicketStatusException(TicketStatusException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .titulo("Bad Request Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
