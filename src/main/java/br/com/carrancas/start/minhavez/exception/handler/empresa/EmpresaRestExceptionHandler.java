package br.com.carrancas.start.minhavez.exception.handler.empresa;

import br.com.carrancas.start.minhavez.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EmpresaRestExceptionHandler {

    @ExceptionHandler(CnpjExistenteException.class)
    private ResponseEntity<ExceptionDetails> handlerCnpjExistenteException(CnpjExistenteException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .status(ex.getStatusCode().value())
                .titulo("Bad Request Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CepInvalidoException.class)
    private ResponseEntity<ExceptionDetails> handlerCepInvalidoException(CepInvalidoException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .status(ex.getStatusCode().value())
                .titulo("Bad Request Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmailExistenteException.class)
    private ResponseEntity<ExceptionDetails> handlerEmailExistenteException(EmailExistenteException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .status(ex.getStatusCode().value())
                .titulo("Bad Request Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmpresaNotFoundException.class)
    private ResponseEntity<ExceptionDetails> handlerEmpresaNotFoundException(EmpresaNotFoundException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .status(ex.getStatusCode().value())
                .titulo("Not Found Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmpresaDesativadaException.class)
    private ResponseEntity<ExceptionDetails> handlerEmpresaDesativadaException(EmpresaDesativadaException ex) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .dataHora(LocalDateTime.now())
                .status(ex.getStatusCode().value())
                .titulo("Not Found Exception, Check a Documentação")
                .detalhes(ex.getMessage())
                .mensagemDesenvolvedor(ex.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }
}
