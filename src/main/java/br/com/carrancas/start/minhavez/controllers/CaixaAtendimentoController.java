package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.CaixaAtendimentoRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.CaixaAtendimentoResponseDTO;
import br.com.carrancas.start.minhavez.services.CaixaAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/caixas-atendimento")
@RequiredArgsConstructor
@RestController
public class CaixaAtendimentoController {

    private final CaixaAtendimentoService caixaAtendimentoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/empresa/{empresaId}")
    public CaixaAtendimentoResponseDTO criar(
            @PathVariable("empresaId") int empresaId,
            @RequestBody CaixaAtendimentoRequestDTO caixaAtendimentoRequestDTO) {

        return caixaAtendimentoService.criar(empresaId, caixaAtendimentoRequestDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<CaixaAtendimentoResponseDTO> listaCaixaAtendimento() {
        return caixaAtendimentoService.listaCaixaAtendimento();
    }
}
