package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;




}
