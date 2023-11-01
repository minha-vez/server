package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "caracteristicas")
    private Set<Hospital> hospitais = new HashSet<>();

    public Caracteristica() {
    }

    public Caracteristica(Integer id, String descricao, Set<Hospital> hospitais) {
        this.id = id;
        this.descricao = descricao;
        this.hospitais = hospitais;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Hospital> getHospitais() {
        return hospitais;
    }
    public void setHospitais(Set<Hospital> hospitais) {
        this.hospitais = hospitais;
    }
}



