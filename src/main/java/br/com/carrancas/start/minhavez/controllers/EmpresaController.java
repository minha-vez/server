package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.EmpresaRequestDto;
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

    @PostMapping("/criar")
    public EmpresaResponseDTO criar(@RequestBody EmpresaRequestDto empresaRequestDto){
        return empresaService.criar(empresaRequestDto);
    }

    @GetMapping
    public List<EmpresaResponseDTO> listarEmpresas(){
        return empresaService.listarEmpresas();
    }
}


