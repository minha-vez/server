package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;

@Entity
public class CaixaAtendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nomeAtendente;
    @Column(nullable = false)
    private boolean status;


    public CaixaAtendimento(Integer id, String nomeAtendente, boolean Status) {
        this.id = id;
        this.nomeAtendente = nomeAtendente;
        this.status = status;
    }

    public CaixaAtendimento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnomeAtendente() {
        return nomeAtendente;
    }

    public void setnomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}