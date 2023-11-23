package br.com.carrancas.start.minhavez.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CnpjExistenteException extends ResponseStatusException {

    public CnpjExistenteException() {
        super(HttpStatus.BAD_REQUEST, "CNPJ já existe no banco de dados");
    }
}
