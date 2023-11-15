package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.CaixaAtendimentoRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.CaixaAtendimentoResponseDTO;
import br.com.carrancas.start.minhavez.entities.CaixaAtendimento;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.repositories.CaixaAtendimentoRepository;
import br.com.carrancas.start.minhavez.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CaixaAtendimentoService {

    private final CaixaAtendimentoRepository caixaAtendimentoRepository;

    private final EmpresaRepository empresaRepository;

    public CaixaAtendimentoResponseDTO criar (int empresaId, CaixaAtendimentoRequestDTO caixaAtendimentoRequestDTO) {
        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(()-> new RuntimeException("Empresa não encontrada"));
        CaixaAtendimento caixaAtendimento = CaixaAtendimentoRequestDTO.toEntity(caixaAtendimentoRequestDTO);
        caixaAtendimento.setEmpresa(empresa);
        caixaAtendimentoRepository.save(caixaAtendimento);
        return CaixaAtendimentoResponseDTO.toDTO(caixaAtendimento);
    }
        public List<CaixaAtendimentoResponseDTO> listaCaixaAtendimento(){
                List<CaixaAtendimento> caixaAtendimenoList = caixaAtendimentoRepository.findAll();
                return caixaAtendimenoList.stream().map(caixaAtendimento -> CaixaAtendimentoResponseDTO.toDTO(caixaAtendimento)).collect(Collectors.toList());
        }


    }