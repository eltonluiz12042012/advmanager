package br.com.api.advmanager.service;

import br.com.api.advmanager.dto.ListagemPessoasDto;
import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.exceptions.EntidadeNotFoundException;
import br.com.api.advmanager.models.Endereco;
import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa cadastrarPessoa(PessoasDTO dados) {
        return pessoaRepository.save(new Pessoa(dados));
    }


    @Transactional(readOnly = true)
    public Page<ListagemPessoasDto> buscarPessoas(Pageable paginacao) {
        return pessoaRepository.findAllByAtivoTrue(paginacao)
                .map(ListagemPessoasDto::new);

    }

    @Transactional(readOnly = true)
    public Pessoa buscarPessoaPorId(Long id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        Pessoa pessoa = obj.orElseThrow(() -> new EntidadeNotFoundException("Cadastro inexistente"));
        return pessoa;
    }
}
