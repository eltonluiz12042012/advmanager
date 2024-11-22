package br.com.api.advmanager.controller;

import br.com.api.advmanager.dto.DadosUpdatePessoa;
import br.com.api.advmanager.dto.ListagemPessoasDto;
import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
   private PessoaService pessoaService;


   @PostMapping
   @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PessoasDTO pessoaDto, UriComponentsBuilder uriBuilder){
       var pessoa  = pessoaService.cadastrarPessoa(pessoaDto);
       var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
       return ResponseEntity.created(uri).body(pessoaDto);
   }

   @GetMapping
   public Page<ListagemPessoasDto> listarTodasASPessoas(@PageableDefault(size = 10, sort = {"id",},direction = Sort.Direction.ASC) Pageable paginacao){
       return pessoaService.buscarPessoas(paginacao);
   }

   @PutMapping
   @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosUpdatePessoa pessoasDTO){
       System.out.println("Dados: " + pessoasDTO);
       var pessoa = pessoaService.buscarPessoaPorId(pessoasDTO.id());
       pessoa.dadosUpdate(pessoasDTO);
       return ResponseEntity.ok(new PessoasDTO(pessoa));
   }

   @DeleteMapping("/{id}")
   @Transactional
    public ResponseEntity exclusaoLogica(@PathVariable Long id){
       var pessoa = pessoaService.buscarPessoaPorId(id);
       pessoa.desativar();
       return ResponseEntity.noContent().build();
   }

   @PatchMapping("/{id}")
   @Transactional
   public ResponseEntity ativandoPessoa(@PathVariable Long id){
       var pessoa = pessoaService.buscarPessoaPorId(id);
       pessoa.ativar();
       return ResponseEntity.ok().build();
   }

   @GetMapping("/{id}")
    public ResponseEntity buscarPessoaPorId(@PathVariable Long id){
       System.out.println("ID: " + id);
       var pessoa = pessoaService.buscarPessoaPorId(id);
       return ResponseEntity.ok(new PessoasDTO(pessoa));
   }


}
