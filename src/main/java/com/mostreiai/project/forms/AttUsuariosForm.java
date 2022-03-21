package com.mostreiai.project.forms;

import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.repository.UsuariosRepository;

public class AttUsuariosForm {
    
    private String email;
    private String cep;
    private String senha;
    private String telefone;
    private String nascimento;


    public Usuarios atualizar(Long id, UsuariosRepository usuariosRepository){
        Usuarios user = usuariosRepository.getById(id);
        user.setEmail(this.email);
        user.setCep(this.cep);
        user.setSenha(this.senha);
        user.setTelefone(this.telefone);
        user.setNascimento(this.nascimento);

        return user;
    }

    public String getEmail(){
        return email;
    }

    public String getCep(){
        return cep;
    }

    public String getSenha(){
        return senha;
    }

    public String getTelefone(){
        return telefone;
    }

    public String getNascimento(){
        return nascimento;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }





}
