package br.com.carrancas.start.minhavez.service;

import br.com.carrancas.start.minhavez.dto.request.CaixaAtendimentoRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.CaixaAtendimentoResponseDTO;
import br.com.carrancas.start.minhavez.entities.CaixaAtendimento;
import br.com.carrancas.start.minhavez.repositories.CaixaAtendimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CaixaAtendimentoService {

    private final CaixaAtendimentoRepository caixaAtendimentoRepository;

    //Create read update delete (CRUD)

    public CaixaAtendimentoResponseDTO criar (CaixaAtendimentoRequestDTO caixaAtendimentoRequestDTO){
        CaixaAtendimento caixaAtendimento = CaixaAtendimentoRequestDTO.toEntity(caixaAtendimentoRequestDTO);
        caixaAtendimentoRepository.save(caixaAtendimento);
        return  CaixaAtendimentoResponseDTO.toDTO(caixaAtendimento);


    }
}