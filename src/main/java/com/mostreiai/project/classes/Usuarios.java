package com.mostreiai.project.classes;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Table(name="usuarios", schema="public")
@Entity
public class Usuarios {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    @Column(name="telefone")
    private String telefone;

    @Column(name="cep")
    private String cep;

    @Column(name="estado")
    private String estado;

    @Column(name="cidade")
    private String cidade;

    @Column(name="nascimento")
    private String nascimento;

    public Usuarios(){

    }

    public Usuarios(String nome, String sobrenome, String email,String senha, String telefone, String cep, String estado, String cidade, String nascimento){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.nascimento = nascimento;
    }

    public Long getId(){
        return id;
    }

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

    public String getNascimento(){
        return nascimento;
   
    }
    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }
}