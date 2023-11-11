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
public class PessoaRequestDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate nascimento;
    private Genero genero;

    public static Pessoa toEntity(PessoaRequestDTO PessoaRequestDTO) {
        return Pessoa.builder()
                .nome(PessoaRequestDTO.getNome())
                .cpf(PessoaRequestDTO.getCpf())
                .telefone(PessoaRequestDTO.getTelefone())
                .nascimento(PessoaRequestDTO.getNascimento())
                .genero(PessoaRequestDTO.getGenero())
                .build();
    }
}
