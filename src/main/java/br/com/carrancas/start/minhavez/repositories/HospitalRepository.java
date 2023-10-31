package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
