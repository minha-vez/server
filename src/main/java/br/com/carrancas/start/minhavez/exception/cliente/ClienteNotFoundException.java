package br.com.carrancas.start.minhavez.exception.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ClienteNotFoundException extends HttpStatusCodeException {

    public ClienteNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }
}
