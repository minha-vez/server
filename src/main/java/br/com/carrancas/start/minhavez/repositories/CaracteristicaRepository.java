package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristicaRepository extends JpaRepository<Especialidade, Integer> {
}
