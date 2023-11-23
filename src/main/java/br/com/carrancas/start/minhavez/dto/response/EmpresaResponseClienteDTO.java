package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Empresa;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponseClienteDTO {

    private String nome;
    private String telefone;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;


    public static EmpresaResponseClienteDTO toDto(Empresa empresa){
        return EmpresaResponseClienteDTO.builder()
                .nome(empresa.getNome())
                .telefone(empresa.getTelefone())
                .cep(empresa.getEndereco().getCep())
                .logradouro(empresa.getEndereco().getLogradouro())
                .complemento(empresa.getEndereco().getComplemento())
                .bairro(empresa.getEndereco().getBairro())
                .localidade(empresa.getEndereco().getLocalidade())
                .uf(empresa.getEndereco().getUf())
                .numero(empresa.getEndereco().getNumero())
                .build();
    }
}



