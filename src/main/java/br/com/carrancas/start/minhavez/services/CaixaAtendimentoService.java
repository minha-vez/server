package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.CaixaAtendimentoRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.CaixaAtendimentoResponseDTO;
import br.com.carrancas.start.minhavez.entities.CaixaAtendimento;
import br.com.carrancas.start.minhavez.repositories.CaixaAtendimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CaixaAtendimentoService {

    private final CaixaAtendimentoRepository caixaAtendimentoRepository;

    //Create read update delete (CRUD)

    public CaixaAtendimentoResponseDTO criar (CaixaAtendimentoRequestDTO caixaAtendimentoRequestDTO) {
        CaixaAtendimento caixaAtendimento = CaixaAtendimentoRequestDTO.toEntity(caixaAtendimentoRequestDTO);
        caixaAtendimentoRepository.save(caixaAtendimento);
        return CaixaAtendimentoResponseDTO.toDTO(caixaAtendimento);
    }
        public List<CaixaAtendimentoResponseDTO> listaCaixaAtendimento(){
                List<CaixaAtendimento> caixaAtendimenoList = caixaAtendimentoRepository.findAll();
                return caixaAtendimenoList.stream().map(caixaAtendimento -> CaixaAtendimentoResponseDTO.toDTO(caixaAtendimento)).collect(Collectors.toList());
        }


    }