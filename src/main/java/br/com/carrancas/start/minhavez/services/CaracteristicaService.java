package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.CaracteristicaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.CaracteristicaResponseDTO;
import br.com.carrancas.start.minhavez.entities.Especialidade;
import br.com.carrancas.start.minhavez.repositories.CaracteristicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CaracteristicaService {


    private final CaracteristicaRepository caracteristicaRepository;

    //Create Read Update Delete (CRUD)

    public CaracteristicaResponseDTO criar (CaracteristicaRequestDto caracteristicaRequestDto){
        Especialidade especialidade = CaracteristicaRequestDto.toEntity(caracteristicaRequestDto);
        caracteristicaRepository.save(especialidade);
        return CaracteristicaResponseDTO.toDto(especialidade);
    }
}
