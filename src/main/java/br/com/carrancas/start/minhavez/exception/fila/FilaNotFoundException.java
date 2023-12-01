package br.com.carrancas.start.minhavez.exception.fila;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilaNotFoundException extends ResponseStatusException {

    public FilaNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Fila não encontrada");
    }
}
