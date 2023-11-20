package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Empresa;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaNewRequestDto {

    private String nome;
    private String cnpj;
    private String cep;
    private String numero;
    private String telefone;
    private String telefoneParaEmergencia;
    private String email;
    private String website;
    private LocalTime horaInicio;
    private LocalTime horaFinal;


    public static Empresa toEntity(EmpresaNewRequestDto empresaNewRequestDto) {
        return Empresa.builder()
                .cnpj(empresaNewRequestDto.getCnpj())
                .nome(empresaNewRequestDto.getNome())
                .telefone(empresaNewRequestDto.getTelefone())
                .website(empresaNewRequestDto.getWebsite())
                .telefoneParaEmergencia(empresaNewRequestDto.getTelefoneParaEmergencia())
                .email(empresaNewRequestDto.getEmail())
                .website(empresaNewRequestDto.getWebsite())
                .horaInicio(empresaNewRequestDto.getHoraInicio())
                .horaFinal(empresaNewRequestDto.getHoraFinal())
                .build();
    }


}
