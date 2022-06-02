package com.incluwed.incluwed.dto;

import com.incluwed.incluwed.classes.Enderecos;
import com.incluwed.incluwed.classes.Telefones;
import com.incluwed.incluwed.classes.Usuarios;
import org.springframework.data.domain.Page;

public class UsuariosDto {
    private long id;
    private String nome;
    private String email;
    private Enderecos endereco;
    private Telefones telefone;
    private String sobrenome;
    private String cpf;
    private String senha;
    private String nascimento;

    public UsuariosDto(Usuarios user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.sobrenome = user.getSobrenome();
        this.email = user.getEmail();
        this.telefone = user.getTelefone();
        this.endereco = user.getEndereco();
        this.cpf = user.getCpf();
        this.senha = user.getSenha();
        this.nascimento = user.getNascimento();
    }

    public static UsuariosDto returnUsuarioDto(Usuarios user){
        UsuariosDto userConvert = new UsuariosDto(user);
        return userConvert;
    }

    public static Page<UsuariosDto> convert(Page<Usuarios> user){
        return user.map(UsuariosDto::new);
    }
    
    public long getId(){
        return id;
    }


    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNascimento(){
        return nascimento;
    }

    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }

}
