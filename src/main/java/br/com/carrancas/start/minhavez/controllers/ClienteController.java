package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.ClienteNewRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.ClienteResponseDTO;
import br.com.carrancas.start.minhavez.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/clientes")
@RequiredArgsConstructor
@RestController
public class ClienteController {
    private final ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
    @PostMapping
    public ClienteResponseDTO criar(@RequestBody ClienteNewRequestDTO clienteNewRequestDTO) {
        return clienteService.criar(clienteNewRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/email/{email}")
    public ClienteResponseDTO buscarPessoaPorEmail(@PathVariable String email){
        return clienteService.buscarPessoaPorEmail(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<ClienteResponseDTO> listarPessoas() {
        return clienteService.listarPessoa();
    }

}
