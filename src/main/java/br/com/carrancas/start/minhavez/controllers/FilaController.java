package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.FilaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.FilaResponseDto;
import br.com.carrancas.start.minhavez.services.FilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/fila")
@RestController
public class FilaController {

    private final FilaService filaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/empresa/{empresaId}")
    public FilaResponseDto criar(@PathVariable int empresaId, @RequestBody FilaRequestDto filaRequestDto) {
        return filaService.criar(empresaId, filaRequestDto);
    }
}
