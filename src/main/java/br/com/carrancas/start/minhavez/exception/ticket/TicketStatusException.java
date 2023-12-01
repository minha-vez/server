package br.com.carrancas.start.minhavez.exception.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TicketStatusException extends ResponseStatusException {

    public TicketStatusException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
