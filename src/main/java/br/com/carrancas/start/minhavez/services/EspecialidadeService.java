package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.EspecialidadeRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EspecialidadeResponseDTO;
import br.com.carrancas.start.minhavez.entities.Especialidade;
import br.com.carrancas.start.minhavez.repositories.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EspecialidadeService {
    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeResponseDTO criar(EspecialidadeRequestDto especialidadeRequestDto) {
        Especialidade especialidade = EspecialidadeRequestDto.toEntity(especialidadeRequestDto);
        especialidadeRepository.save(especialidade);
        return EspecialidadeResponseDTO.toDto(especialidade);
    }

    public List<EspecialidadeResponseDTO> listarEspecialidade() {
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        return especialidades.stream().map(especialidade -> EspecialidadeResponseDTO.toDto(especialidade))
                .collect(Collectors.toList());
    }

}
