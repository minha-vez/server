package br.com.carrancas.start.minhavez.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int ordem;

    @Column(nullable = false)
    private LocalTime horaEntrada;

    @ManyToOne
    @JoinColumn(name = "fila_id")
    private Fila fila;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


}
