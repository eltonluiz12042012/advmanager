package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.Feriado;
import br.com.api.advmanager.models.enums.TipoFeriado;

import java.time.LocalDate;

public class ListagemFeriadoDto {

    private LocalDate data;
    private String nome;
    private TipoFeriado tipoFeriado;
    private String cidade;

    public ListagemFeriadoDto(){

    }

    public ListagemFeriadoDto(LocalDate data, String nome, TipoFeriado tipoFeriado, String cidade) {
        this.data = data;
        this.nome = nome;
        this.tipoFeriado = tipoFeriado;
        this.cidade = cidade;
    }

    public ListagemFeriadoDto(Feriado feriado) {
        System.out.println(feriado);
        this.cidade = feriado.getCidade();
        this.data = feriado.getData();
        this.nome = feriado.getNome();
        this.tipoFeriado = feriado.getTipoFeriado();
    }

    public LocalDate getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public TipoFeriado getTipoFeriado() {
        return tipoFeriado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoFeriado(TipoFeriado tipoFeriado) {
        this.tipoFeriado = tipoFeriado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "ListagemFeriadoDto{" +
                "data=" + data +
                ", nome='" + nome + '\'' +
                ", tipoFeriado=" + tipoFeriado +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
