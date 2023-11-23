package br.com.carrancas.start.minhavez.repositories;

import br.com.carrancas.start.minhavez.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Integer> {
    Optional<UserDetails> findByEmail(String username);
}
