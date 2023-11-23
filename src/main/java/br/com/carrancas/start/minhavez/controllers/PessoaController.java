package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.PessoaNewRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.PessoaResponseDTO;
import br.com.carrancas.start.minhavez.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoas")
@RequiredArgsConstructor
@RestController
public class PessoaController {
    private final PessoaService pessoaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PessoaResponseDTO criar(@RequestBody PessoaNewRequestDTO pessoaNewRequestDTO) {
        return pessoaService.criar(pessoaNewRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PessoaResponseDTO> listarPessoas() {
        return pessoaService.listarPessoa();
    }

}
