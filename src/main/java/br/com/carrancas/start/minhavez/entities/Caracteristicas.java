package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;

@Entity
public class Caracteristicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    public Caracteristicas() {
    }

    public Caracteristicas(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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
}



