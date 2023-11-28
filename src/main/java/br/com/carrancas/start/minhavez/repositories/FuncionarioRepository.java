package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Optional<Funcionario> findByEmail(String email);
}
