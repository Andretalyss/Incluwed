package com.incluwed.incluwed.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.incluwed.incluwed.interfaces.UsuariosInterface;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name="usuarios", schema="public")
@Entity
public class Usuarios implements UsuariosInterface, UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfis = new ArrayList<>();

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
