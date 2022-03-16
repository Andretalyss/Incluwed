package com.mostreiai.project.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mostreiai.project.classes.Usuarios;

import org.hibernate.validator.constraints.Length;

public class UsuarioForms {
    
    @NotNull @NotEmpty @Length(max = 12)
    private String nome;

    @NotNull @NotEmpty @Length(max = 30)
    private String sobrenome;

    @NotNull @NotEmpty @Length(max = 25)
    private String email;

    @NotNull @NotEmpty @Size(min = 8, max = 18)
    private String senha;

    @NotNull @NotEmpty @Length(max = 12)
    private String telefone;

    @NotNull @NotEmpty @Length(max = 10)
    private String cep;

    @NotNull @NotEmpty @Length(max = 15)
    private String estado;

    @NotNull @NotEmpty @Length(max = 20)
    private String cidade;

    @NotNull @NotEmpty @Length(max = 12)
    private String data;


    public String getNome(){
        return nome;
    }
    public String getSobrenome(){
        return sobrenome;
    }
    public String getEmail(){
        return email;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getCep(){
        return cep;
    }
    public String getEstado(){
        return estado;
    }
    public String getCidade(){
        return cidade;
    }
    public String getData(){
        return data;
    }
    public String getSenha(){
        return senha;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setCep(String cep){
        this.cep = cep;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }


    public Usuarios converter() {
        return new Usuarios(nome, sobrenome, email, senha, telefone, cep, estado, cidade, data);
    }

}
