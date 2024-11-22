package br.com.api.advmanager.models;

import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.dto.ProcessosDTO;
import br.com.api.advmanager.models.enums.StatusProcesso;
import br.com.api.advmanager.service.PessoaService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "processos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")

public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processo;

    @ManyToOne
    private Pessoa autor;

    private String reu;

    @OneToMany(mappedBy = "processos")
    private List<PessoaProcesso> pessoaProcesso =  new ArrayList<>();

    private String comarca;
    private String estado;
    @Column(name = "numero_vara")
    private Long numeroVara;
    private String vara;
    private String acao;

  //  @OneToMany
  //  private List<MovimentacaoProcessual> movimentacaoProcessual;
    @Column(name = "situacao_atual")
    private String situacalAtual;
    @Column(name = "valor_causa")
    private Double valorCausa;
    @Enumerated(EnumType.STRING)
    private StatusProcesso status;
    private LocalDateTime dataProtocolo;



    public Processo(ProcessosDTO processosDTO){
        this.id = processosDTO.id();
        this.acao = processosDTO.acao();
        this.processo = processosDTO.processo();
        this.autor = processosDTO.autor();
        this.reu = processosDTO.reu();
        this.comarca = processosDTO.comarca();
        this.estado = processosDTO.estado();
        this.numeroVara = processosDTO.numeroVara();
        this.vara = processosDTO.vara();
        this.situacalAtual = processosDTO.situacaoAtual();
        this.valorCausa = processosDTO.valorCausa();
        this.status = processosDTO.status();
        this.dataProtocolo = processosDTO.dataProtocolo();
    }
}
