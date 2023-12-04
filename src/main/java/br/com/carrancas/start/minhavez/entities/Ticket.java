package br.com.carrancas.start.minhavez.entities;

import br.com.carrancas.start.minhavez.enums.Status;
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

    @OneToOne
    @JoinColumn(name = "caixa_atendimento_id")
    private CaixaAtendimento caixaAtendimento;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false)
    private Status statusAtendimento = Status.ESPERA;

    @ManyToOne
    @JoinColumn(name = "fila_id")
    private Fila fila;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
