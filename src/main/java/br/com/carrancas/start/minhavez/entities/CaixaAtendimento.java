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
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;


    public CaixaAtendimento(Integer id, String nomeAtendente, boolean status, Hospital hospital) {
        this.id = id;
        this.nomeAtendente = nomeAtendente;
        this.status = status;
        this.hospital = hospital;
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

    public Hospital getHospital() {
        return hospital;
    }
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}