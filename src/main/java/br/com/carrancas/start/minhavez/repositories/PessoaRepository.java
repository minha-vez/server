package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

    Optional<Pessoa> findByEmail(String email);
}




