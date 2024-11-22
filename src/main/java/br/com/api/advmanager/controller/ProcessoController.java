package br.com.api.advmanager.controller;

import br.com.api.advmanager.dto.ListagemPessoasDto;
import br.com.api.advmanager.dto.ListagemProcessosDTO;
import br.com.api.advmanager.dto.ProcessosDTO;
import br.com.api.advmanager.models.Processo;
import br.com.api.advmanager.service.ProcessoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;
//    @GetMapping
//    public ResponseEntity<Page<ListagemProcessosDTO>> buscarTodosProcessos(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
//            @RequestParam(value = "orderBy", defaultValue = "reu") String orderBy,
//            @RequestParam(value = "direction", defaultValue = "ASC") String direction
//    ){
//        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction) , orderBy);
//        Page<ListagemProcessosDTO> processos = processoService.findAllPaged(pageRequest);
//        return ResponseEntity.ok(processos);
//    }

    @PostMapping
    @Transactional
    public ResponseEntity Cadastrar(@RequestBody ProcessosDTO dados){
        System.out.println(dados);
        processoService.salvar(dados);
        return ResponseEntity.ok(dados);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListagemProcessosDTO> findProcessosById(@PathVariable Long id){
        System.out.println(id);
        var processoDTO = processoService.findById(id);
        return ResponseEntity.ok().body(processoDTO);
    }

    @GetMapping
    public Page<ListagemProcessosDTO> FindAllProcess(@PageableDefault(size = 10, direction = Sort.Direction.DESC) Pageable paginacao){
        return processoService.findAllPaged(paginacao);
    }
}
