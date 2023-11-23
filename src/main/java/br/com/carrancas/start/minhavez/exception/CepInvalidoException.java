package br.com.carrancas.start.minhavez.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CepInvalidoException extends ResponseStatusException {

    public CepInvalidoException() {
        super(HttpStatus.BAD_REQUEST, "CEP inválido ou não encontrado");
    }
}
