package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Funcionario;
import br.com.carrancas.start.minhavez.enums.Genero;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioRequestDTO {

    private String nome;
    private String matricula;
    private String telefone;
    private String password;
    private Genero genero;

    public static Funcionario toEntity(FuncionarioRequestDTO funcionarioRequestDTO) {
        return Funcionario.builder()
                .nome(funcionarioRequestDTO.getNome())
                .matricula(funcionarioRequestDTO.getMatricula())
                .telefone(funcionarioRequestDTO.getTelefone())
                .genero(funcionarioRequestDTO.getGenero())
                .build();

    }


}


