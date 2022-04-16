package com.mostreiai.project.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.repository.UsuariosRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

public class AttUsuariosForm {
    
    @NotNull @NotEmpty @Length(max = 25)
    private String email;

    @NotNull @NotEmpty @Length(max = 10)
    private String cep;

    @NonNull @NotEmpty @Size(min=8, max=12)
    private String senha;

    @NotNull @NotEmpty @Length(max = 12)
    private String telefone;

    @NotNull @NotEmpty @Length(max = 12)
    private String nascimento;


    public Usuarios atualizar(Long id, UsuariosRepository usuariosRepository){
        Usuarios user = usuariosRepository.getById(id);
        user.setEmail(this.email);
        user.setCep(this.cep);
        user.setTelefone(this.telefone);
        user.setNascimento(this.nascimento);

        return user;
    }

    public Usuarios atualizarSenha(Long id, UsuariosRepository usuariosRepository){
        Usuarios user = usuariosRepository.getById(id);
        user.setSenha(this.senha);

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
