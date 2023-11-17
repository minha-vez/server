package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.ConvenioRequestDto;
import br.com.carrancas.start.minhavez.dto.response.ConvenioResponseDto;
import br.com.carrancas.start.minhavez.services.ConvenioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convenios")
@RequiredArgsConstructor
public class ConvenioController {

    private final ConvenioService convenioService;

    @PostMapping("/empresa/{empresaId}")
    public ConvenioResponseDto criar(
            @PathVariable("empresaId") int empresaId,
            @RequestBody ConvenioRequestDto convenioRequestDto) {
        return convenioService.criar(empresaId, convenioRequestDto);
    }
}
