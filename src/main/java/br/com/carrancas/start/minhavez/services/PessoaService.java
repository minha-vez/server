package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.PessoaRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.PessoaResponseDTO;
import br.com.carrancas.start.minhavez.entities.Pessoa;
import br.com.carrancas.start.minhavez.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    //Create read update delete (CRUD)

    public PessoaResponseDTO criar (PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = PessoaRequestDTO.toEntity(pessoaRequestDTO);
        pessoaRepository.save(pessoa);
        return PessoaResponseDTO.toDto(pessoa);

    }

    public List<PessoaResponseDTO> listaPessoa(){
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList.stream().map(pessoa -> PessoaResponseDTO.toDto(pessoa)).collect(Collectors.toList());
    }

}