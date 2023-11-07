package br.com.carrancas.start.minhavez.dto;

import br.com.carrancas.start.minhavez.entities.Pessoa;
import br.com.carrancas.start.minhavez.eums.Genero;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponseDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private Date nascimento;
    private Genero genero;

    public static PessoaResponseDTO toDto(Pessoa pessoa) {
        return PessoaResponseDTO.builder()
                .nome(pessoa.getNome())
                .cpf(pessoa.getCpf())
                .telefone(pessoa.getTelefone())
                .nascimento(pessoa.getNascimento())
                .genero(pessoa.getGenero())
                .build();
    }

}
