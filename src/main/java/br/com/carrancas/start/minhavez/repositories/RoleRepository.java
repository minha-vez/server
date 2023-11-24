package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role_cliente);
}
