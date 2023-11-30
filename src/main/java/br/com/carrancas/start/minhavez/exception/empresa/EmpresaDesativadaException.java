package br.com.carrancas.start.minhavez.exception.empresa;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmpresaDesativadaException extends ResponseStatusException {

    public EmpresaDesativadaException() {
        super(HttpStatus.NOT_FOUND, "Empresa desativada");
    }
}
