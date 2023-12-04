package br.com.carrancas.start.minhavez.exception.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClienteEmFilaException extends ResponseStatusException {

    public ClienteEmFilaException() {
        super(HttpStatus.BAD_REQUEST, "Cliente já está em uma fila");
    }
}
