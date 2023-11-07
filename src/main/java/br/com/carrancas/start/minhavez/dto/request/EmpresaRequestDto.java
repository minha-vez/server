package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Empresa;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequestDto {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String telefoneParaEmergencia;
    private String email;
    private String website;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFinal;
    private Boolean status;


    public static Empresa toEntity(EmpresaRequestDto empresaRequestDto){
        return Empresa.builder()
                .cnpj(empresaRequestDto.getCnpj())
                .nome(empresaRequestDto.getNome())
                .endereco(empresaRequestDto.getEndereco())
                .telefone(empresaRequestDto.getTelefone())
                .website(empresaRequestDto.getWebsite())
                .telefoneParaEmergencia(empresaRequestDto.getTelefoneParaEmergencia())
                .email(empresaRequestDto.getEmail())
                .website(empresaRequestDto.getWebsite())
                .horaInicio(empresaRequestDto.getHoraInicio())
                .horaFinal(empresaRequestDto.getHoraFinal())
                .status(Boolean.TRUE)
                .build();
    }


}
