package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Empresa;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponseDTO {

    private String nome;
    private String endereco;
    private String telefone;
    private String telefoneParaEmergencia;
    private String email;
    private String website;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFinal;


    public static EmpresaResponseDTO toDto(Empresa empresa){
        return EmpresaResponseDTO.builder()
                .nome(empresa.getNome())
                .endereco(empresa.getEndereco())
                .telefone(empresa.getTelefone())
                .website(empresa.getWebsite())
                .telefoneParaEmergencia(empresa.getTelefoneParaEmergencia())
                .email(empresa.getEmail())
                .website(empresa.getWebsite())
                .horaInicio(empresa.getHoraInicio())
                .horaFinal(empresa.getHoraFinal())
                .build();
    }
}