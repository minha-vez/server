package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Pessoa;
import br.com.carrancas.start.minhavez.eums.Genero;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaNewRequestDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate nascimento;
    private Genero genero;
    private String cep;
    private String numero;

    public static Pessoa toEntity(PessoaNewRequestDTO pessoaNewRequestDTO) {
        return Pessoa.builder()
                .nome(pessoaNewRequestDTO.getNome())
                .cpf(pessoaNewRequestDTO.getCpf())
                .telefone(pessoaNewRequestDTO.getTelefone())
                .nascimento(pessoaNewRequestDTO.getNascimento())
                .genero(pessoaNewRequestDTO.getGenero())
                .email(pessoaNewRequestDTO.getEmail())
                .build();
    }
}
