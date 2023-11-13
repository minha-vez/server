package br.com.carrancas.start.minhavez;

import br.com.carrancas.start.minhavez.client.EnderecoViaCepClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MinhaVezApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhaVezApplication.class, args);}

}
