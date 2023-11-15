package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.client.EnderecoViaCepClient;
import br.com.carrancas.start.minhavez.dto.request.EmpresaNewRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseDTO;
import br.com.carrancas.start.minhavez.dto.request.EnderecoRequestDTO;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Endereco;
import br.com.carrancas.start.minhavez.repositories.EmpresaRepository;
import br.com.carrancas.start.minhavez.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final EnderecoRepository enderecoRepository;
    private final EnderecoViaCepClient enderecoViaCepClient;

    @Transactional
    public EmpresaResponseDTO criar (EmpresaNewRequestDto empresaNewRequestDto){
        EnderecoRequestDTO enderecoRequestDTO = enderecoViaCepClient.buscarViaCep(empresaNewRequestDto.getCep());
        Endereco endereco = EnderecoRequestDTO.toEntity(enderecoRequestDTO);
        endereco.setNumero(empresaNewRequestDto.getNumero());
        Empresa empresa = EmpresaNewRequestDto.toEntity(empresaNewRequestDto);
        salvarEmpresaComEndereco(endereco, empresa);
        return EmpresaResponseDTO.toDto(empresa);
    }
    private void salvarEmpresaComEndereco(Endereco endereco, Empresa empresa) {
        endereco.setEmpresa(empresa);
        enderecoRepository.save(endereco);
        empresaRepository.save(empresa);
    }

    public List<EmpresaResponseDTO> listarEmpresas(){
        List<Empresa> empresaList = empresaRepository.findAll();
       return empresaList.stream().map(empresa -> EmpresaResponseDTO.toDto(empresa)).collect(Collectors.toList());
    }
}
