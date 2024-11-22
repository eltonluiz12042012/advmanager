package br.com.api.advmanager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pessoa_processos")
public class PessoaProcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Processo processos;
    @ManyToOne
    private Pessoa autor;

    public PessoaProcesso(Integer id, Processo processos, Pessoa autor) {
        this.id = id;
        this.processos = processos;
        this.autor = autor;
    }

    public PessoaProcesso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Processo getProcessos() {
        return processos;
    }

    public void setProcessos(Processo processos) {
        this.processos = processos;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "PessoaProcesso{" +
                "id=" + id +
                ", processos=" + processos +
                ", autor=" + autor +
                '}';
    }
}
