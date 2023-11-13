package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
