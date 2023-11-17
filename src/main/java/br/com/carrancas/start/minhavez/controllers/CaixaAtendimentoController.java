package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.CaixaAtendimentoRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.CaixaAtendimentoResponseDTO;
import br.com.carrancas.start.minhavez.services.CaixaAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/caixas-atendimento")
@RequiredArgsConstructor
@RestController
public class CaixaAtendimentoController {

    private final CaixaAtendimentoService caixaAtendimentoService;

    @PostMapping("/empresa/{empresaId}")
    public CaixaAtendimentoResponseDTO criar(
            @PathVariable("empresaId") int empresaId,
            @RequestBody CaixaAtendimentoRequestDTO caixaAtendimentoRequestDTO) {

        return caixaAtendimentoService.criar(empresaId, caixaAtendimentoRequestDTO);
    }

    @GetMapping
    public List<CaixaAtendimentoResponseDTO> listaCaixaAtendimento() {
        return caixaAtendimentoService.listaCaixaAtendimento();
    }
}
