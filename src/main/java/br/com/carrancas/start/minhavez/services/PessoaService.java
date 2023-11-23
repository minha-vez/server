package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.client.EnderecoViaCepClient;
import br.com.carrancas.start.minhavez.dto.request.EnderecoRequestDTO;
import br.com.carrancas.start.minhavez.dto.request.PessoaNewRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.PessoaResponseDTO;
import br.com.carrancas.start.minhavez.entities.Endereco;
import br.com.carrancas.start.minhavez.entities.Pessoa;
import br.com.carrancas.start.minhavez.repositories.EnderecoRepository;
import br.com.carrancas.start.minhavez.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final EnderecoViaCepClient enderecoViaCepClient;

    @Transactional
    public PessoaResponseDTO criar(PessoaNewRequestDTO pessoaNewRequestDTO) {
        // TODO criar um DTO para criar pessoa, e dentro dele pegar os campos password e email, e salvar usuario e pessoa ao mesmo tempo
        EnderecoRequestDTO enderecoRequestDTO = enderecoViaCepClient.buscarViaCep(pessoaNewRequestDTO.getCep());
        Endereco endereco = EnderecoRequestDTO.toEntity(enderecoRequestDTO);
        endereco.setNumero(pessoaNewRequestDTO.getNumero());
        Pessoa pessoa = PessoaNewRequestDTO.toEntity(pessoaNewRequestDTO);
        salvarPessoaEndereco(endereco, pessoa);
        return PessoaResponseDTO.toDto(pessoa);
    }

    private void salvarPessoaEndereco(Endereco endereco, Pessoa pessoa) {
        endereco.setPessoa(pessoa);
        pessoaRepository.save(pessoa);
        enderecoRepository.save(endereco);
    }

    public Pessoa getPessoa(String email) {
        return pessoaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

    }

    public List<PessoaResponseDTO> listarPessoa() {
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList.stream()
                .map(pessoa -> PessoaResponseDTO.toDto(pessoa))
                .collect(Collectors.toList());
    }

}