package br.com.carrancas.start.minhavez.service;

import br.com.carrancas.start.minhavez.dto.request.EmpresaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseDTO;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaResponseDTO criar(EmpresaRequestDto empresaRequestDto){
        Empresa empresa = EmpresaRequestDto.toEntity(empresaRequestDto);
        empresaRepository.save(empresa);
        return EmpresaResponseDTO.toDto(empresa);
    }
}
