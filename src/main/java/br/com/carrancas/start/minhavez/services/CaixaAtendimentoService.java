package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.CaixaAtendimentoRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.CaixaAtendimentoResponseDTO;
import br.com.carrancas.start.minhavez.dto.response.TicketResponseTelaDTO;
import br.com.carrancas.start.minhavez.entities.CaixaAtendimento;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.repositories.CaixaAtendimentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CaixaAtendimentoService {

    private final CaixaAtendimentoRepository caixaAtendimentoRepository;
    private final EmpresaService empresaService;

    private final TicketService ticketService;

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

    public CaixaAtendimento getCaixaAtendimento(int caixaId){
        //TODO criar a validação se caixa existe e exceção personalizada aqui
        return caixaAtendimentoRepository.findById(caixaId)
                .orElseThrow(() -> new RuntimeException("Caixa não encontrado"));
    }
    @Transactional
    public TicketResponseTelaDTO atenderTicket(int ticketId, int caixaId){
        //TODO fazer a validação se o caixa esta atendendo um ticket que pertence a empresa dele, e validar se o status está ativo
        Ticket ticket = ticketService.atenderTicket(ticketId);
        ticket.setCaixaAtendimento(getCaixaAtendimento(caixaId));
        return TicketResponseTelaDTO.builder()
                .ordem(ticket.getOrdem())
                .nome(ticket.getCliente().getNome())
                .nomeEstabelecimento(ticket.getFila().getEmpresa().getNome())
                .build();
    }

    public void finalizarTicket(int ticketId){
        ticketService.finalizarTicket(ticketId);
    }

}