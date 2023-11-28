package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Ticket;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

//    Optional<Ticket> findFirstByFilaEmpresaIdOrderByDataCriacaoDesc(int empresaId);

    @Query(value = "SELECT t.* FROM ticket t " +
            "JOIN fila f ON t.fila_id = f.id " +
            "WHERE f.empresa_id = :empresaId " +
            "AND DATE(t.data_criacao) = :data " +
            "ORDER BY t.data_criacao DESC, t.ordem DESC LIMIT 1", nativeQuery = true)
    Optional<Ticket> findLastTicketByEmpresaIdAndData(
            @Param("empresaId") Integer empresaId,
            @Param("data") LocalDate data
    );
}
