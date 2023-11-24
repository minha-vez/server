package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.EmpresaNewRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseClienteDTO;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseDTO;
import br.com.carrancas.start.minhavez.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/empresas")
@RequiredArgsConstructor
@RestController
public class EmpresaController {

    private final EmpresaService empresaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public EmpresaResponseDTO criar(@RequestBody EmpresaNewRequestDto empresaNewRequestDto){
        return empresaService.criar(empresaNewRequestDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('FUNCIONARIO', 'ADMIN')")
    @GetMapping
    public List<EmpresaResponseDTO> listarEmpresas(){
        return empresaService.listarEmpresas();
    }

    @GetMapping("/{empresaId}")
    public EmpresaResponseClienteDTO buscarEmpresaById(@PathVariable int empresaId){
        return empresaService.buscarEmpresaById(empresaId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{empresaId}")
    public void deletarEmpresa(@PathVariable int empresaId){
        empresaService.deletarEmpresa(empresaId);
    }
}


