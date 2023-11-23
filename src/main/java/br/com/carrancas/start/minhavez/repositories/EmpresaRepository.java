package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    boolean existsByCnpj(String cnpj);
}
