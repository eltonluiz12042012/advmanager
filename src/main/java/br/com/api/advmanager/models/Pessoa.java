package br.com.api.advmanager.models;

import br.com.api.advmanager.dto.DadosUpdatePessoa;
import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.models.enums.EstadoCivil;
import br.com.api.advmanager.models.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity()
@Table(name="pessoas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private String email;

   // @Column(unique=true)
    private String cpf;

   // @Column(unique=true)
    private String rg;

   // @Column(unique=true)
    private String cnpj;

    private String profissao;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    private String nacionalidade;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    private boolean ativo = true;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private String celular;
    private String telefoneComercial;

    //private List<Processo> processos = new ArrayList<>();

    public Pessoa(PessoasDTO dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.dataNascimento = dados.dataNascimento();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.rg = dados.rg();
        this.cnpj = dados.cnpj();
        this.profissao = dados.profissao();
        this.tipoPessoa = dados.tipoPessoa();
        this.nacionalidade = dados.nacionalidade();
        this.estadoCivil = dados.estadoCivil();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.celular = dados.celular();
        this.telefoneComercial = dados.telefoneComercial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(sexo, pessoa.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void dadosUpdate(DadosUpdatePessoa pessoasDTO){
        if(pessoasDTO.nome()!=null){
            this.nome = pessoasDTO.nome();
        }

        if(pessoasDTO.sexo()!=null){
            this.sexo= pessoasDTO.sexo();
        }

        if(pessoasDTO.dataNascimento()!=null){
            this.dataNascimento = pessoasDTO.dataNascimento();
        }

        if(pessoasDTO.cpf()!=null) {
            this.cpf = pessoasDTO.cpf();
        }
        if(pessoasDTO.rg()!=null) {
            this.rg = pessoasDTO.rg();
        }
        if(pessoasDTO.cnpj()!=null) {
            this.cnpj = pessoasDTO.cnpj();
        }
        if(pessoasDTO.profissao()!=null) {
            this.profissao = pessoasDTO.profissao();
        }
        if(pessoasDTO.tipoPessoa()!=null) {
            this.tipoPessoa = pessoasDTO.tipoPessoa();
        }
        if(pessoasDTO.nacionalidade()!=null) {
            this.nacionalidade = pessoasDTO.nacionalidade();
        }
        if(pessoasDTO.endereco()!=null) {
            this.endereco.updateEndereco(pessoasDTO.endereco());
        }
        if(pessoasDTO.telefone()!=null) {
            this.telefone = pessoasDTO.telefone();
        }
        if(pessoasDTO.celular()!=null) {
            this.celular = pessoasDTO.celular();
        }
        if(pessoasDTO.telefoneComercial()!=null) {
            this.telefoneComercial = pessoasDTO.telefoneComercial();
        }
        if(pessoasDTO.email()!=null){
            this.email = pessoasDTO.email();
        }
        if(pessoasDTO.estadoCivil()!=null){
            this.estadoCivil = pessoasDTO.estadoCivil();
        }


    }

    public void desativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
