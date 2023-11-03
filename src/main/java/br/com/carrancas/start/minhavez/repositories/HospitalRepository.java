package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalRepository extends JpaRepository<Empresa, Integer> {

}
