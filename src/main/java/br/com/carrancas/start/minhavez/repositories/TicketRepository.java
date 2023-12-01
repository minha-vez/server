package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Cliente;
import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.eums.Status;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("SELECT COUNT(t) > 0 FROM Ticket t WHERE t.cliente = :cliente AND t.statusAtendimento IN (:statusList)")
    boolean existsByClienteAndStatusIn(@Param("cliente") Cliente cliente, @Param("statusList") List<Status> statusList);


    @Query(value = "SELECT t.* FROM ticket t " +
            "JOIN fila f ON t.fila_id = f.id " +
            "WHERE f.empresa_id = :empresaId " +
            "AND DATE(t.data_criacao) = :data " +
            "ORDER BY t.data_criacao DESC, t.ordem DESC LIMIT 1", nativeQuery = true)
    Optional<Ticket> findLastTicketByEmpresaIdAndData(
            @Param("empresaId") Integer empresaId,
            @Param("data") LocalDate data
    );

    boolean existsByCliente(Cliente cliente);
}
