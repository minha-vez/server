package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.PessoaRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.PessoaResponseDTO;
import br.com.carrancas.start.minhavez.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoa")
@RequiredArgsConstructor
@RestController
public class PessoaController {
    private final PessoaService pessoaService;

    @PostMapping("/criar")
    public PessoaResponseDTO criar(@RequestBody PessoaRequestDTO pessoaRequestDTO){
        return pessoaService.criar(pessoaRequestDTO);

    }

    @GetMapping
    public List<PessoaResponseDTO> listaPessoa(){
        return pessoaService.listaPessoa();
    }

}
