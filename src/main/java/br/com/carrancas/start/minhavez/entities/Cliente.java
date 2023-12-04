package br.com.carrancas.start.minhavez.entities;

import br.com.carrancas.start.minhavez.enums.Genero;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(unique = true)
    private String telefone;

    @Column(nullable = false)
    private LocalDate nascimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @JsonBackReference
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private Endereco endereco;
}


