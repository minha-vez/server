package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Funcionario;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponseDTO {

    private String matricula;
    private String empresa;
    private String email;


    public static FuncionarioResponseDTO toDto(Funcionario funcionario) {
        return FuncionarioResponseDTO.builder()
                .matricula(funcionario.getMatricula())
                .empresa(funcionario.getEmpresa().getNome())
                .email(funcionario.getEmail())
                .build();
    }

}