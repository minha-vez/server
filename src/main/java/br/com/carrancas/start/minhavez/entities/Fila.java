package br.com.carrancas.start.minhavez.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    @Column(nullable = false)
    private LocalDate data = LocalDate.now();

    @Column(nullable = false)
    private Boolean preferencial;
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @JsonBackReference
    @OneToMany(mappedBy = "fila", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

}

