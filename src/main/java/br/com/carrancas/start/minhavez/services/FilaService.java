package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.FilaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.FilaResponseDto;
import br.com.carrancas.start.minhavez.entities.Fila;
import br.com.carrancas.start.minhavez.repositories.FilaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FilaService {

    private final FilaRepository filaRepository;

    public FilaResponseDto criar(FilaRequestDto filaRequestDto){
        Fila fila = FilaRequestDto.toEntity(filaRequestDto);
        filaRepository.save(fila);
        return FilaResponseDto.toDto(fila);
    }

    public Fila getFila(int filaId){
        return filaRepository.findById(filaId)
                .orElseThrow(() -> new RuntimeException("Fila não encontrada"));
    }

}
