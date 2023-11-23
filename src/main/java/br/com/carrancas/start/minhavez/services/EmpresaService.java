package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.client.EnderecoViaCepClient;
import br.com.carrancas.start.minhavez.dto.request.EmpresaNewRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EmpresaResponseDTO;
import br.com.carrancas.start.minhavez.dto.request.EnderecoRequestDTO;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Endereco;
import br.com.carrancas.start.minhavez.exception.CepInvalidoException;
import br.com.carrancas.start.minhavez.exception.CnpjExistenteException;
import br.com.carrancas.start.minhavez.exception.EmailExistenteException;
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
    public EmpresaResponseDTO criar(EmpresaNewRequestDto empresaNewRequestDto) {
        validarCnpjNaoExistente(empresaNewRequestDto.getCnpj());
        validarEmailNaoExistente(empresaNewRequestDto.getEmail());
        validarEndereco(empresaNewRequestDto.getCep());

        Endereco endereco = criarEndereco(empresaNewRequestDto);
        Empresa empresa = EmpresaNewRequestDto.toEntity(empresaNewRequestDto);
        salvarEmpresaEndereco(endereco, empresa);

        return EmpresaResponseDTO.toDto(empresa);
    }

    private void validarCnpjNaoExistente(String cnpj) {
        if (empresaRepository.existsByCnpj(cnpj)) {
            throw new CnpjExistenteException();
        }
    }

    private void validarEmailNaoExistente(String email) {
        if (empresaRepository.existsByEmail(email)) {
            throw new EmailExistenteException();
        }
    }

    private void validarEndereco(String cep) {
        EnderecoRequestDTO enderecoRequestDTO = enderecoViaCepClient.buscarViaCep(cep);
        if (enderecoRequestDTO.getLogradouro() == null || enderecoRequestDTO.getLocalidade() == null) {
            throw new CepInvalidoException();
        }
    }

    private Endereco criarEndereco(EmpresaNewRequestDto empresaNewRequestDto) {
        EnderecoRequestDTO enderecoRequestDTO = enderecoViaCepClient.buscarViaCep(empresaNewRequestDto.getCep());
        Endereco endereco = EnderecoRequestDTO.toEntity(enderecoRequestDTO);
        endereco.setNumero(empresaNewRequestDto.getNumero());
        return endereco;
    }

    private void salvarEmpresaEndereco(Endereco endereco, Empresa empresa) {
        endereco.setEmpresa(empresa);
        enderecoRepository.save(endereco);
        empresaRepository.save(empresa);
    }


    public List<EmpresaResponseDTO> listarEmpresas() {
        List<Empresa> empresaList = empresaRepository.findAll();
        return empresaList.stream()
                .filter(empresa -> empresa.getStatus().equals(Boolean.TRUE))
                .map(empresa -> EmpresaResponseDTO.toDto(empresa))
                .collect(Collectors.toList());
    }

    public Empresa getEmpresa(int empresaId) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        if (empresa.getStatus() == Boolean.FALSE) {
            throw new RuntimeException("Empresa desativada");
        }
        return empresa;
    }

    public void deletarEmpresa(int empresaId){
        Empresa empresa = getEmpresa(empresaId);
        empresa.setStatus(Boolean.FALSE);
        empresaRepository.save(empresa);
    }
}
