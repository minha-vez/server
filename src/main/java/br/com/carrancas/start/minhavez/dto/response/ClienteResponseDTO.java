package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Cliente;
import br.com.carrancas.start.minhavez.eums.Genero;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate nascimento;
    private Genero genero;

    public static ClienteResponseDTO toDto(Cliente cliente) {
        return ClienteResponseDTO.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .telefone(cliente.getTelefone())
                .nascimento(cliente.getNascimento())
                .genero(cliente.getGenero())
                .build();
    }

}
