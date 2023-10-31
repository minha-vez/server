package br.com.carrancas.start.minhavez.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CaixaAtendimento> caixaAtendimentoList;

    @JsonBackReference
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fila> filaList;

    public Hospital(Integer id, String nome, String cnpj, String endereco, Boolean status, List<CaixaAtendimento> caixaAtendimentoList, List<Fila> filaList) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.status = status;
        this.caixaAtendimentoList = caixaAtendimentoList;
        this.filaList = filaList;
    }

    public Hospital() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<CaixaAtendimento> getCaixaAtendimentoList() {
        return caixaAtendimentoList;
    }

    public void setCaixaAtendimentoList(List<CaixaAtendimento> caixaAtendimentoList) {
        this.caixaAtendimentoList = caixaAtendimentoList;
    }

    public List<Fila> getFilaList() {
        return filaList;
    }

    public void setFilaList(List<Fila> filaList) {
        this.filaList = filaList;
    }
}


