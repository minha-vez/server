package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository  extends JpaRepository<Ticket, Integer> {

}
