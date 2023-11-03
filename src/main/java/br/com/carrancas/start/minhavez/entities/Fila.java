package br.com.carrancas.start.minhavez.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Date data;
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @JsonBackReference
    @OneToMany(mappedBy = "fila", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FilaDia> filaDiaList;

    public Fila() {
    }

    public Fila(Integer id, Date data, Empresa empresa) {
        this.id = id;
        this.data = data;
        this.empresa = empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

