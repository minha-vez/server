package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.ConvenioRequestDto;
import br.com.carrancas.start.minhavez.dto.response.ConvenioResponseDto;
import br.com.carrancas.start.minhavez.entities.Convenio;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.repositories.ConvenioRepository;
import br.com.carrancas.start.minhavez.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConvenioService {

    private final ConvenioRepository convenioRepository;
    private final EmpresaService empresaService;

    public ConvenioResponseDto criar(int empresaId, ConvenioRequestDto convenioRequestDto) {
        Empresa empresa = empresaService.getEmpresa(empresaId);
        Convenio convenio = ConvenioRequestDto.toEntity(convenioRequestDto);
        convenio.setEmpresa(empresa);
        convenioRepository.save(convenio);
        return ConvenioResponseDto.toDto(convenio);
    }

}
