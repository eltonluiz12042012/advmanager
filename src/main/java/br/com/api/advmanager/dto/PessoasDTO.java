package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.Endereco;
import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.models.enums.EstadoCivil;
import br.com.api.advmanager.models.enums.TipoPessoa;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record PessoasDTO(
        Long id,
        @NotBlank(message = "O nome é um campo obrigatório")
        String nome,

        @NotNull
        LocalDate dataNascimento,

        @NotBlank(message = "O campo email deve ser informado.")
        @Email(message = "Formato do campo incorreto.")
        String email,
        @Pattern(regexp = "\\d{11}", message = "Número de caracteres inválidos.")
        String cpf,


        @Pattern(regexp = "\\d{7,10}")
        String rg,

        @Pattern(regexp = "\\{14}")
        String cnpj,

        @NotNull
        TipoPessoa tipoPessoa,
        @NotBlank
        String profissao,
        @NotBlank
        String nacionalidade,
        @NotNull
        EstadoCivil estadoCivil,
        @NotBlank
        String sexo,

        @NotNull
        boolean ativo,

        @NotNull
        @Valid
        EnderecoDTO endereco,
        String telefone,
        String celular,
        String telefoneComercial) {
        public PessoasDTO(Pessoa pessoa) {
                this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEmail(), pessoa.getCpf(), pessoa.getRg(), pessoa.getCnpj(), pessoa.getTipoPessoa(), pessoa.getProfissao(), pessoa.getNacionalidade(), pessoa.getEstadoCivil(), pessoa.getSexo(),pessoa.isAtivo(), new EnderecoDTO(pessoa.getEndereco()), pessoa.getTelefone(), pessoa.getCelular(), pessoa.getTelefoneComercial());
        }
}
