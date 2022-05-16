package com.incluwed.incluwed.forms;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UsuariosLoginForm {
    private String email;
    private String senha;

    public UsuariosLoginForm(){}

    public UsuariosLoginForm(String email,String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken convert(){
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
