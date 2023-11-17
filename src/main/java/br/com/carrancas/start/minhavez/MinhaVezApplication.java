package br.com.carrancas.start.minhavez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MinhaVezApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinhaVezApplication.class, args);
    }

}
