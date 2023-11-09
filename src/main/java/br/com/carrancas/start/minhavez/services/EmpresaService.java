package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.EmpresaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseDTO;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    //Create Read Update Delete (CRUD)

    public EmpresaResponseDTO criar (EmpresaRequestDto empresaRequestDto){
        Empresa empresa = EmpresaRequestDto.toEntity(empresaRequestDto);
        empresaRepository.save(empresa);
        return EmpresaResponseDTO.toDto(empresa);
    }

    public List<EmpresaResponseDTO> listarEmpresas(){
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream().map(empresa -> EmpresaResponseDTO.toDto(empresa)).collect(Collectors.toList());


    }
}
