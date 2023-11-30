package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.AuthenticationRequest;
import br.com.carrancas.start.minhavez.dto.response.AuthenticationResponse;
import br.com.carrancas.start.minhavez.services.AuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request) {
        return service.authenticate(request);
    }


    @GetMapping("/decode/{token}")
    public ResponseEntity<?> decodeToken(@PathVariable String token) {
        return service.decodeToken(token);
    }


}
