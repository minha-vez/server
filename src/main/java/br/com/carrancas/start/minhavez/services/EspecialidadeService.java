package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.EspecialidadeRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EspecialidadeResponseDTO;
import br.com.carrancas.start.minhavez.entities.Especialidade;
import br.com.carrancas.start.minhavez.repositories.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EspecialidadeService {


    private final EspecialidadeRepository caracteristicaRepository;

    //Create Read Update Delete (CRUD)

    public EspecialidadeResponseDTO criar (EspecialidadeRequestDto especialidadeRequestDto){
        Especialidade especialidade = EspecialidadeRequestDto.toEntity(especialidadeRequestDto);
        caracteristicaRepository.save(especialidade);
        return EspecialidadeResponseDTO.toDto(especialidade);
    }
}
