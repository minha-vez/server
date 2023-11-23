package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Ticket;
import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {

    private int ordem;
    private LocalTime horaEntrada;
    private String nomePessoa;
    private String nomeEmpresa;


    public static TicketResponseDto toDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .ordem(ticket.getOrdem())
                .horaEntrada(ticket.getHoraEntrada())
                .nomePessoa(ticket.getPessoa().getNome())
                .nomeEmpresa(ticket.getFila().getEmpresa().getNome()).build();

    }


}
