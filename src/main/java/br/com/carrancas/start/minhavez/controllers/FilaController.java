package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.FilaRequestDto;
import br.com.carrancas.start.minhavez.dto.response.FilaResponseDto;
import br.com.carrancas.start.minhavez.services.FilaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/fila")
@RestController
public class FilaController {

    private final FilaService filaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/empresa/{empresaId}")
    public FilaResponseDto criar(@PathVariable int empresaId, @RequestBody FilaRequestDto filaRequestDto) {
        return filaService.criar(empresaId, filaRequestDto);
    }
}
