package br.com.carrancas.start.minhavez.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mapeia a configuração para todas as URLs
                .allowedOrigins("http://dominio-permitido.com") // Define o domínio permitido
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("Authorization", "Content-Type") // Cabeçalhos permitidos
                .exposedHeaders("Authorization") // Cabeçalhos expostos
                .allowCredentials(true) // Permite credenciais
                .maxAge(3600); // Tempo máximo do cache das opções pré-vôo
    }
}
