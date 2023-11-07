package br.com.carrancas.start.minhavez.entities;
import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class FilaDia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int ordem;

    private LocalTime horaEntrada;

    @ManyToOne
    @JoinColumn(name = "fila_id")
    private Fila fila;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


}
