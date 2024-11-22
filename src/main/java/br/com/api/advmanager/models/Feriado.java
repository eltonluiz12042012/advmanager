package br.com.api.advmanager.models;

import br.com.api.advmanager.dto.FeriadoDTO;
import br.com.api.advmanager.models.enums.TipoFeriado;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "feriados")
public class Feriado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate data;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_feriado")
    private TipoFeriado tipoFeriado;

    private String cidade;
    private String estado;

    public Feriado() {
    }

    public Feriado(Long id, LocalDate data, TipoFeriado tipoFeriado, String nome, String cidade, String estado) {
        this.id = id;
        this.data = data;
        this.tipoFeriado = tipoFeriado;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Feriado(FeriadoDTO feriadoDTO){
        this.id = feriadoDTO.getId();
        this.data = feriadoDTO.getData();
        this.tipoFeriado = feriadoDTO.getTipoFeriado();
        this.nome = feriadoDTO.getNome();
        this.estado = feriadoDTO.getEstado();
        this.cidade = feriadoDTO.getCidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TipoFeriado getTipoFeriado() {
        return tipoFeriado;
    }

    public void setTipoFeriado(TipoFeriado tipoFeriado) {
        this.tipoFeriado = tipoFeriado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feriado feriado)) return false;
        return Objects.equals(id, feriado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Feriado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", tipoFeriado=" + tipoFeriado +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
