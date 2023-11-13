package br.com.carrancas.start.minhavez.dto.response;

import br.com.carrancas.start.minhavez.entities.Endereco;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EnderecoResponseDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public static Endereco toEntity(EnderecoResponseDTO enderecoResponseDTO){
        return Endereco
                .builder()
                .cep(enderecoResponseDTO.getCep())
                .bairro(enderecoResponseDTO.getBairro())
                .complemento(enderecoResponseDTO.getComplemento())
                .localidade(enderecoResponseDTO.getLocalidade())
                .logradouro(enderecoResponseDTO.getLogradouro())
                .uf(enderecoResponseDTO.getUf())
                .build();
    }


}