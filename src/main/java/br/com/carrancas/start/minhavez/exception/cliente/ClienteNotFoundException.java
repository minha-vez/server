package br.com.carrancas.start.minhavez.exception.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClienteNotFoundException extends ResponseStatusException {

    public ClienteNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }
}
