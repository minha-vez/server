package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Funcionario;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponseDTO {

    private String matricula;
    private String password;

    public static FuncionarioResponseDTO toDto(Funcionario funcionario) {
        return FuncionarioResponseDTO.builder()
                .matricula(funcionario.getMatricula())
                .password(funcionario.getPassword())
                .build();
    }

}