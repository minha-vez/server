package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "caracteristicas")
    private Set<Empresa> empresas = new HashSet<>();

    public Caracteristica() {
    }

    public Caracteristica(Integer id, String descricao, Set<Empresa> empresas) {
        this.id = id;
        this.descricao = descricao;
        this.empresas = empresas;
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

    public Set<Empresa> getEmpresas() {
        return empresas;
    }
    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }
}



