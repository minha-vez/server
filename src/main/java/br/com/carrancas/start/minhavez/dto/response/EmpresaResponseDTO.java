package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Empresa;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponseDTO {

    private String nome;
    private String telefone;
    private String telefoneParaEmergencia;
    private String email;
    private String website;
    private LocalTime horaInicio;
    private LocalTime horaFinal;


    public static EmpresaResponseDTO toDto(Empresa empresa){
        return EmpresaResponseDTO.builder()
                .nome(empresa.getNome())
                .email(empresa.getEmail())
                .telefone(empresa.getTelefone())
                .website(empresa.getWebsite())
                .telefoneParaEmergencia(empresa.getTelefoneParaEmergencia())
                .horaInicio(empresa.getHoraInicio())
                .horaFinal(empresa.getHoraFinal())
                .build();
    }
}
