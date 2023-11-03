package br.com.carrancas.start.minhavez.entities;

import br.com.carrancas.start.minhavez.eums.Genero;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private Date nascimento;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @ManyToOne
    @JoinColumn (name = "fila_id", nullable = false )
    private Fila fila;



    public Cliente() {
    }

    public Cliente(Integer id, String nome, String cpf, Date nascimento, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.genero = genero;
        this.fila = fila;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Fila getFila() { return fila; }

    public void setFila(Fila fila) { this.fila = fila;}
}


