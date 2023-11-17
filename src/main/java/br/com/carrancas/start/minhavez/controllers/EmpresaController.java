package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.EmpresaNewRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseDTO;
import br.com.carrancas.start.minhavez.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/empresas")
@RequiredArgsConstructor
@RestController
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public EmpresaResponseDTO criar(@RequestBody EmpresaNewRequestDto empresaNewRequestDto){
        return empresaService.criar(empresaNewRequestDto);
    }

    @GetMapping
    public List<EmpresaResponseDTO> listarEmpresas(){
        return empresaService.listarEmpresas();
    }
}


