package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository  extends JpaRepository<Ticket, Integer> {

    Optional<Ticket> findFirstByFilaEmpresaIdOrderByDataCriacaoDesc(int empresaId);

}
