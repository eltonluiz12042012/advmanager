package br.com.api.advmanager.exceptions;

import br.com.api.advmanager.controller.exception.ErroPadrao;
import br.com.api.advmanager.dto.DadosErroValidacaoCampos;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(EntidadeNotFoundException.class)
    ResponseEntity<ErroPadrao> entidadeInexistente(EntidadeNotFoundException e, HttpServletRequest request){
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("Registro não encontrado");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity ManipularErro400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacaoCampos::new).toList());
    }

    @ExceptionHandler(FeriadoException.class)
    public ResponseEntity<ErroPadrao> validarFeriado(FeriadoException ex){
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setError("Dados incosistentes");
        erro.setPath("/feriados");
        erro.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
