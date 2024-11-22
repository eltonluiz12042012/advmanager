package br.com.api.advmanager.dto;

import org.springframework.validation.FieldError;

public class DadosErroValidacaoCampos {
    private String campo;
    private String mensagems;

    public DadosErroValidacaoCampos(FieldError error) {
        this.campo = error.getField();
        this.mensagems = error.getDefaultMessage();
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagems() {
        return mensagems;
    }

    public void setMensagems(String mensagems) {
        this.mensagems = mensagems;
    }
}
