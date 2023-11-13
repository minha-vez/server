package br.com.carrancas.start.minhavez.client;

import br.com.carrancas.start.minhavez.dto.response.EnderecoResponseDTO;
import br.com.carrancas.start.minhavez.entities.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-endereco", url = "https://viacep.com.br/ws")
public interface EnderecoViaCepClient {

    @GetMapping("/{cep}/json")
    EnderecoResponseDTO buscarViaCep(@PathVariable String cep);

}
