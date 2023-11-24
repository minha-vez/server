package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    Optional<Cliente> findByEmail(String email);
}




