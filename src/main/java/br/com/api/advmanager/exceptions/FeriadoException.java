package br.com.api.advmanager.exceptions;

public class FeriadoException extends RuntimeException {
    public FeriadoException(String mensagem){
        super(mensagem);
    }
}
