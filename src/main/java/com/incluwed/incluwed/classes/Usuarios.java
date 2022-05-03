package com.incluwed.incluwed.classes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.incluwed.incluwed.interfaces.UsuariosInterface;

@Table(name="usuarios", schema="public")
@Entity
public class Usuarios implements UsuariosInterface {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

    @Column(name="cpf")
    private String cpf;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    @Column(name="nascimento")
    private String nascimento;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="endereco_id")
    private Enderecos endereco;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="telefone_id")
    private Telefones telefone;

    public Usuarios(){}

    public Usuarios(String nome, String sobrenome, String cpf, String email, String senha, String nascimento, Enderecos endereco, Telefones telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    @Override
    public String getNome(){
        return nome;
    }

    @Override
    public long getId(){
        return id;
    }

    @Override
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String getSobrenome(){
        return sobrenome;
    }

    @Override
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    @Override
    public String getCpf(){
        return cpf;
    }

    @Override
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    @Override
    public String getEmail(){
        return email;
    }

    @Override
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String getSenha(){
        return senha;
    }

    @Override
    public void setSenha(String senha){
        this.senha = senha;
    }

    @Override
    public String getNascimento(){
        return nascimento;
    }

    @Override
    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }

    public Enderecos getEndereco() {
        return endereco;
    }

    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }

    public Telefones getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefones telefone) {
        this.telefone = telefone;
    }

}
