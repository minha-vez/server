package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.config.JwtService;
import br.com.carrancas.start.minhavez.dto.request.AuthenticationRequest;
import br.com.carrancas.start.minhavez.dto.response.AuthenticationResponse;
import br.com.carrancas.start.minhavez.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final UsuarioRepository usuarioRepository;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        UserDetails usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String jwtToken = jwtService.generateToken(userDetails);


        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .email(userDetails.getUsername())
                .build();
    }

}
