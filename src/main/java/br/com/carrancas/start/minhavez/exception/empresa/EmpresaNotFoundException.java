package br.com.carrancas.start.minhavez.exception.empresa;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmpresaNotFoundException extends ResponseStatusException {

    public EmpresaNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Empresa não encontrada no banco de dados");
    }
}
