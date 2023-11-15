package br.com.carrancas.start.minhavez.dto.request;

import br.com.carrancas.start.minhavez.entities.Endereco;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EnderecoRequestDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public static Endereco toEntity(EnderecoRequestDTO enderecoRequestDTO){
        return Endereco
                .builder()
                .cep(enderecoRequestDTO.getCep())
                .bairro(enderecoRequestDTO.getBairro())
                .complemento(enderecoRequestDTO.getComplemento())
                .localidade(enderecoRequestDTO.getLocalidade())
                .logradouro(enderecoRequestDTO.getLogradouro())
                .uf(enderecoRequestDTO.getUf())
                .build();
    }


}