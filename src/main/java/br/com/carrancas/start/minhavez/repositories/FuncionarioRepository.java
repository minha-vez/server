package br.com.carrancas.start.minhavez.repositories;


import br.com.carrancas.start.minhavez.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
