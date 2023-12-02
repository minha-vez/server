package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.CaixaAtendimentoRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.CaixaAtendimentoResponseDTO;
import br.com.carrancas.start.minhavez.entities.CaixaAtendimento;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.repositories.CaixaAtendimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CaixaAtendimentoService {

    private final CaixaAtendimentoRepository caixaAtendimentoRepository;
    private final EmpresaService empresaService;

    public CaixaAtendimentoResponseDTO criar(int empresaId, CaixaAtendimentoRequestDTO caixaAtendimentoRequestDTO) {
        Empresa empresa = empresaService.getEmpresa(empresaId);
        CaixaAtendimento caixaAtendimento = CaixaAtendimentoRequestDTO.toEntity(caixaAtendimentoRequestDTO);
        caixaAtendimento.setEmpresa(empresa);
        caixaAtendimentoRepository.save(caixaAtendimento);
        return CaixaAtendimentoResponseDTO.toDTO(caixaAtendimento);
    }

    public List<CaixaAtendimentoResponseDTO> listaCaixaAtendimentoPorEmpresa(int empresaId){
        Empresa empresa = empresaService.getEmpresa(empresaId);
        List<CaixaAtendimento> listCaixaAtendimento = caixaAtendimentoRepository.findAll();
        return listCaixaAtendimento.stream()
                .filter(cx -> cx.getEmpresa() == empresa)
                .map(caixaAtendimento -> CaixaAtendimentoResponseDTO.toDTO(caixaAtendimento))
                .collect(Collectors.toList());
    }

}