package com.incluwed.incluwed.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuariosResetPasswordForm {

    @NotEmpty @NotNull
    private String token;

    @NotNull @NotEmpty
    private String senha;

    public UsuariosResetPasswordForm(){}
    
    public UsuariosResetPasswordForm(String token, String senha){
        this.token = token;
        this.senha = senha;
    }

    public String getSenha(){
        return senha;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }


}
