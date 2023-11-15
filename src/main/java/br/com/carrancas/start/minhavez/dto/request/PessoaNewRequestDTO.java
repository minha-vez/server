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
    private LocalDate nascimento;
    private Genero genero;
    private String cep;
    private String numero;

    public static Pessoa toEntity(PessoaNewRequestDTO PessoaNewRequestDTO) {
        return Pessoa.builder()
                .nome(PessoaNewRequestDTO.getNome())
                .cpf(PessoaNewRequestDTO.getCpf())
                .telefone(PessoaNewRequestDTO.getTelefone())
                .nascimento(PessoaNewRequestDTO.getNascimento())
                .genero(PessoaNewRequestDTO.getGenero())
                .build();
    }
}
