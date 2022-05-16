package com.incluwed.incluwed.infrastructure.config;

public class ErrorsFormularioDto {
    private String campo;
    private String erro;

    public ErrorsFormularioDto(String campo, String erro){
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }


    
}
