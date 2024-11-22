package br.com.api.advmanager.controller;

import br.com.api.advmanager.dto.FeriadoDTO;
import br.com.api.advmanager.dto.ListagemFeriadoDto;
import br.com.api.advmanager.models.Feriado;
import br.com.api.advmanager.service.FeriadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/feriados")
public class FeriadosController {

    @Autowired
    private FeriadoService feriadoService;

    @GetMapping
    @Transactional(readOnly = true)
    public Page<ListagemFeriadoDto> buscarTodosOsFeriados(@PageableDefault(size = 10, sort = {"data",},direction = Sort.Direction.ASC) Pageable paginacao){
        return feriadoService.buscarTodosOsFeriados(paginacao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid FeriadoDTO feriadoDTO, UriComponentsBuilder uriBuilder){
        var feriado = feriadoService.cadastrar(feriadoDTO);
        System.out.println(feriado);
        var uri = uriBuilder.path("/feriados/{id}").buildAndExpand(feriado.getId()).toUri();
        return ResponseEntity.created(uri).body(feriado);

    }

    @GetMapping("/{municipio}")
    public Page<ListagemFeriadoDto> listarPorMunicipio(@PageableDefault(size = 10, sort = {"cidade",},direction = Sort.Direction.ASC) Pageable paginacao, String municipio){
        return feriadoService.buscarTodosFeriados(paginacao);
    }

}
