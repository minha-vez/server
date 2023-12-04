package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Funcionario;
import br.com.carrancas.start.minhavez.enums.Genero;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioNewRequestDTO {

    private String nome;
    private String matricula;
    private String telefone;
    private String email;
    private String password;
    private LocalDate nascimento;
    private Genero genero;

    public static Funcionario toEntity(FuncionarioNewRequestDTO funcionarioNewRequestDTO) {
        return Funcionario.builder()
                .nome(funcionarioNewRequestDTO.getNome())
                .matricula(funcionarioNewRequestDTO.getMatricula())
                .email(funcionarioNewRequestDTO.getEmail())
                .telefone(funcionarioNewRequestDTO.getTelefone())
                .nascimento(funcionarioNewRequestDTO.getNascimento())
                .genero(funcionarioNewRequestDTO.getGenero())
                .build();
    }
}
