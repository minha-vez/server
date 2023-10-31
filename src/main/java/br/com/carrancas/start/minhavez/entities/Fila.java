package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Fila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Column(name= "data", nullable = false)
    private LocalDate data;

    public Fila(Integer id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public Fila() {
    }


}
