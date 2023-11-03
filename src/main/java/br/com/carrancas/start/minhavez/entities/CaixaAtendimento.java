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
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;


    public CaixaAtendimento(Integer id, String nomeAtendente, boolean status, Empresa empresa) {
        this.id = id;
        this.nomeAtendente = nomeAtendente;
        this.status = status;
        this.empresa = empresa;
    }

    public CaixaAtendimento() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}