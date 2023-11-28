package br.com.carrancas.start.minhavez.controllers;


import br.com.carrancas.start.minhavez.dto.request.FuncionarioNewRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.FuncionarioResponseDTO;
import br.com.carrancas.start.minhavez.services.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
@RestController
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
    @PostMapping("/empresa/{empresaId}")
    public FuncionarioResponseDTO criar(@PathVariable int empresaId, @RequestBody FuncionarioNewRequestDTO funcionarioNewRequestDTO) {
        return funcionarioService.criar(empresaId, funcionarioNewRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<FuncionarioResponseDTO> listarPessoas() {
        return funcionarioService.listarPessoa();
    }

}
