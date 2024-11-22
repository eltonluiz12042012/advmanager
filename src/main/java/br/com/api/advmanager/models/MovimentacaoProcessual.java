package br.com.api.advmanager.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="movimentacao_processual")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
public class MovimentacaoProcessual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String descricao;
    private LocalDateTime dataHoraMovimentacao = LocalDateTime.now();
}
