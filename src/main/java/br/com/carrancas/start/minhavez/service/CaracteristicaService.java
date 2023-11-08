package br.com.carrancas.start.minhavez.service;

import br.com.carrancas.start.minhavez.dto.request.CaracteristicaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.CaracteristicaResponseDTO;
import br.com.carrancas.start.minhavez.entities.Caracteristica;
import br.com.carrancas.start.minhavez.repositories.CaracteristicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CaracteristicaService {


    private final CaracteristicaRepository caracteristicaRepository;

    //Create Read Update Delete (CRUD)

    public CaracteristicaResponseDTO criar (CaracteristicaRequestDto caracteristicaRequestDto){
        Caracteristica caracteristica = CaracteristicaRequestDto.toEntity(caracteristicaRequestDto);
        caracteristicaRepository.save(caracteristica);
        return CaracteristicaResponseDTO.toDto(caracteristica);
    }
}
