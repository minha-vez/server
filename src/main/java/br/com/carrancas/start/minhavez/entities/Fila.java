package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Date data;
    private Integer quantidadeMaxima;

    public Fila() {
    }
    public Fila(Integer id, String nome, Date data, Integer quantidadeMaxima) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(Integer quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }
}
