package br.com.carrancas.start.minhavez.entities;

import br.com.carrancas.start.minhavez.eums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int ordem;

    @Builder.Default
    @Column(nullable = false)
    private LocalDate dataCriacao = LocalDate.now();

    @Builder.Default
    @Column(nullable = false)
    private LocalTime horaEntrada = LocalTime.now();

    private LocalTime horaEncerramento;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false)
    private Status statusAtendimento = Status.ESPERA;

    @ManyToOne
    @JoinColumn(name = "fila_id")
    private Fila fila;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
