package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.FilaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.FilaResponseDto;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Fila;
import br.com.carrancas.start.minhavez.repositories.FilaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FilaService {

    private final FilaRepository filaRepository;

    private final EmpresaService empresaService;

    public FilaResponseDto criar(int empresaId, FilaRequestDto filaRequestDto) {
        Fila fila = FilaRequestDto.toEntity(filaRequestDto);
        Empresa empresa = empresaService.getEmpresa(empresaId);
        fila.setEmpresa(empresa);
        filaRepository.save(fila);
        return FilaResponseDto.toDto(fila);
    }

    public Fila getFila(int filaId) {
        return filaRepository.findById(filaId)
                .orElseThrow(() -> new RuntimeException("Fila não encontrada"));
    }

}
