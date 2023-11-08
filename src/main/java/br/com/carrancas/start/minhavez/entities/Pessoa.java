package br.com.carrancas.start.minhavez.entities;

import br.com.carrancas.start.minhavez.eums.Genero;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(unique = true)
    private String telefone;

    @Column(nullable = false)
    private Date nascimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Ticket ticket;
}


