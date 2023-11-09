package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {
}
