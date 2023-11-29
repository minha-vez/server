package br.com.carrancas.start.minhavez.exception.empresa;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailExistenteException extends ResponseStatusException {

    public EmailExistenteException() {
        super(HttpStatus.BAD_REQUEST, "Email já existe no banco de dados");
    }
}
