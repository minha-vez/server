package br.com.carrancas.start.minhavez.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private String endereco;

    private String telefone;

    private String telefoneParaEmergencia;

    private String email;

    private String website;

    private LocalDateTime horaInicio;

    private LocalDateTime horaFinal;

    //Precisamos criar um campo com lista de Convenio que hospital aceita


    @Column(nullable = false)
    private Boolean status;
    @JsonBackReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CaixaAtendimento> caixaAtendimentoList;
    @JsonBackReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fila> filaList;

    // Poderiamos trocar o nome caracteristicas por "Especialidades"
    @ManyToMany
    @JoinTable(name = "empresa_caracteristicas",
            joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristicas_id"))
    private Set<Caracteristica> caracteristicas = new HashSet<>();
    public Empresa(Integer id, String nome, String cnpj, String endereco, Boolean status, List<CaixaAtendimento> caixaAtendimentoList, List<Fila> filaList, Set<Caracteristica> caracteristicas) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.status = status;
        this.caixaAtendimentoList = caixaAtendimentoList;
        this.filaList = filaList;
        this.caracteristicas = caracteristicas;
    }

    public Empresa() {
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

    public Set<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}


