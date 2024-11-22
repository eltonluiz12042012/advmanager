package br.com.api.advmanager.service;


import br.com.api.advmanager.dto.FeriadoDTO;
import br.com.api.advmanager.dto.ListagemFeriadoDto;
import br.com.api.advmanager.dto.ListagemPessoasDto;
import br.com.api.advmanager.exceptions.FeriadoException;
import br.com.api.advmanager.models.Feriado;
import br.com.api.advmanager.repository.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeriadoService {

    @Autowired
    private FeriadoRepository feriadoRepository;

    @Transactional(readOnly = true)
    public Page<ListagemFeriadoDto> buscarTodosOsFeriados(Pageable paginacao) {
        return feriadoRepository.findAll(paginacao)
                .map(ListagemFeriadoDto::new);
    }

    @Transactional
    public Feriado cadastrar(FeriadoDTO feriadoDTO) {
        System.out.println(feriadoDTO.getTipoFeriado().toString());
        if(feriadoDTO.getTipoFeriado().toString()=="MUNICIPAL" && (feriadoDTO.getCidade()==null)){
            System.out.println(feriadoDTO);
            throw new FeriadoException("Para feriados municipais é necessário informar a cidade");
        }
        if(feriadoDTO.getTipoFeriado().toString()=="MUNICIPAL" && (feriadoDTO.getEstado()==null)){
            System.out.println(feriadoDTO);
            throw new FeriadoException("Para feriados municipais é necessário informar o estado");
        }
         return feriadoRepository.save(new Feriado(feriadoDTO));
    }

    @Transactional(readOnly = true)
    public Page<ListagemFeriadoDto> buscarTodosFeriados(Pageable paginacao){
        return feriadoRepository.findAll(paginacao).map(ListagemFeriadoDto::new);
    }



}
