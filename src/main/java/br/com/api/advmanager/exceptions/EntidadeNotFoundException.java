package br.com.api.advmanager.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class EntidadeNotFoundException extends RuntimeException {

    public EntidadeNotFoundException(String msg) {
        super(msg);
    }

}
