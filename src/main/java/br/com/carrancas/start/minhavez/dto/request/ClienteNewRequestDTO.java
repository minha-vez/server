package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Cliente;
import br.com.carrancas.start.minhavez.eums.Genero;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteNewRequestDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String password;
    private LocalDate nascimento;
    private Genero genero;
    private String cep;
    private String numero;

    public static Cliente toEntity(ClienteNewRequestDTO clienteNewRequestDTO) {
        return Cliente.builder()
                .nome(clienteNewRequestDTO.getNome())
                .cpf(clienteNewRequestDTO.getCpf())
                .email(clienteNewRequestDTO.getEmail())
                .telefone(clienteNewRequestDTO.getTelefone())
                .nascimento(clienteNewRequestDTO.getNascimento())
                .genero(clienteNewRequestDTO.getGenero())
                .build();
    }
}
