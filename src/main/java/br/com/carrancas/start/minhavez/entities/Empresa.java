package br.com.carrancas.start.minhavez.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String telefone;

    private String telefoneParaEmergencia;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String website;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFinal;

    @Column(nullable = false)
    private Boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CaixaAtendimento> caixaAtendimentoList;

    @JsonBackReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fila> filaList;

    @JsonBackReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Convenio> convenioList;

    @ManyToMany
    @JoinTable(name = "empresa_especialidade",
            joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private Set<Especialidade> especialidades = new HashSet<>();
}


