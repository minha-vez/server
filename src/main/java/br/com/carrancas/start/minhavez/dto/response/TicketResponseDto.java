package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Ticket;
import br.com.carrancas.start.minhavez.enums.Status;
import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {

    private Integer id;
    private int ordem;
    private LocalTime horaEntrada;
    private String nomePessoa;
    private String nomeEmpresa;
    private Status statusAtendimento;
    private Boolean isPreferencial;

    public static TicketResponseDto toDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .id(ticket.getId())
                .ordem(ticket.getOrdem())
                .horaEntrada(ticket.getHoraEntrada())
                .nomePessoa(ticket.getCliente().getNome())
                .nomeEmpresa(ticket.getFila().getEmpresa().getNome())
                .statusAtendimento((ticket.getStatusAtendimento()))
                .isPreferencial(ticket.getFila().getPreferencial())
                .build();

    }


}
