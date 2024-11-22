package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.Feriado;
import br.com.api.advmanager.models.enums.TipoFeriado;
import org.flywaydb.core.internal.util.JsonUtils;

import java.time.LocalDate;

public class FeriadoDTO {
    private Long id;

    private String nome;

    private LocalDate data;

    private TipoFeriado tipoFeriado;

    private String cidade;

    private String estado;

    public FeriadoDTO() {
    }

    public FeriadoDTO(Long id, String nome, LocalDate data, TipoFeriado tipoFeriado, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.tipoFeriado = tipoFeriado;
        this.cidade = cidade;
        this.estado = estado;
    }

    public FeriadoDTO(Feriado feriado) {
        this.id = feriado.getId();
        this.data = feriado.getData();
        this.tipoFeriado= feriado.getTipoFeriado();
        this.nome = feriado.getNome();
        this.cidade = feriado.getCidade();
        this.estado = feriado.getEstado();
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

    @Override
    public String toString() {
        return "FeriadoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", tipoFeriado=" + tipoFeriado +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

