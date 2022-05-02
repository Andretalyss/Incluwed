package com.incluwed.incluwed.dto;

import com.incluwed.incluwed.classes.Enderecos;
import com.incluwed.incluwed.classes.Telefones;
import com.incluwed.incluwed.classes.Usuarios;

import org.springframework.data.domain.Page;

public class UsuariosDto {
    private long userId;
    private String userNome;
    private String userEmail;
    private Enderecos endereco;
    private Telefones telefone;

    public UsuariosDto(Usuarios user){
        this.userId = user.getId();
        this.userNome = user.getNome();
        this.userEmail = user.getEmail();
        this.telefone = user.getTelefone();
        this.endereco = user.getEndereco();
    }

    public static UsuariosDto returnUsuarioDto(Usuarios user){
        UsuariosDto userConvert = new UsuariosDto(user);
        return userConvert;


    }

    public static Page<UsuariosDto> convert(Page<Usuarios> user){
        return user.map(UsuariosDto::new);
    }
    
    public long getUserId(){
        return userId;
    }


    public String getUserNome(){
        return userNome;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public void setUserId(long userId){
        this.userId = userId;
    }

    public void setUserNome(String userNome){
        this.userNome = userNome;
    }

    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
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
