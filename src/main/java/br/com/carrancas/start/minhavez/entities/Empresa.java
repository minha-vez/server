package br.com.carrancas.start.minhavez.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String endereco;

    private String telefone;

    private String telefoneParaEmergencia;

    private String email;

    private String website;

    private LocalDateTime horaInicio;

    private LocalDateTime horaFinal;

    //Precisamos criar um campo com lista de Convenio que hospital aceita

    @Column(nullable = false)
    private Boolean status;
    @JsonBackReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CaixaAtendimento> caixaAtendimentoList;
    @JsonBackReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fila> filaList;

    // Poderiamos trocar o nome caracteristicas por "Especialidades"
    @ManyToMany
    @JoinTable(name = "empresa_caracteristicas",
            joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristicas_id"))
    private Set<Caracteristica> caracteristicas = new HashSet<>();
}


