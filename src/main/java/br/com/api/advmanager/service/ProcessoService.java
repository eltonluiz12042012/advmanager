package br.com.api.advmanager.service;

import br.com.api.advmanager.dto.ListagemProcessosDTO;
import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.dto.ProcessosDTO;
import br.com.api.advmanager.models.Processo;
import br.com.api.advmanager.repository.PessoaRepository;
import br.com.api.advmanager.repository.ProcessoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
//    public Page<ListagemProcessosDTO> buscarTodosProcessos(Pageable paginas) {
//        return processoRepository.findAll(paginas)
//                .map(ListagemProcessosDTO::new);
//    }

    public void salvar(ProcessosDTO processosDTO) {
   var processo = new Processo(processosDTO);
        processoRepository.save(processo);
    }


    @Transactional(readOnly = true)
    public Page<ListagemProcessosDTO> findAllPaged(Pageable paginacao) {
        Page<Processo> processos = processoRepository.findAll(paginacao);
        return processos.map(p -> new ListagemProcessosDTO(p));
    }

    public ListagemProcessosDTO findById(Long id) {
        System.out.println("ID: " + id);
        return new ListagemProcessosDTO(processoRepository.getReferenceById(id));

    }
}
