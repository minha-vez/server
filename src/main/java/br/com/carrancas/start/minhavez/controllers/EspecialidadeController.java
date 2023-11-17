package br.com.carrancas.start.minhavez.controllers;

import br.com.carrancas.start.minhavez.dto.request.EspecialidadeRequestDto;
import br.com.carrancas.start.minhavez.dto.response.EspecialidadeResponseDTO;
import br.com.carrancas.start.minhavez.services.EspecialidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {
    private final EspecialidadeService especialidadeService;

    @PostMapping
    public EspecialidadeResponseDTO criar(@RequestBody EspecialidadeRequestDto especialidadeRequestDto) {
        return especialidadeService.criar(especialidadeRequestDto);
    }

    @GetMapping
    public List<EspecialidadeResponseDTO> ListarEspecialidades() {
        return especialidadeService.listarEspecialidade();
    }
}
