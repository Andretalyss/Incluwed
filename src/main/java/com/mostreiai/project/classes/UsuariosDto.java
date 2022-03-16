package com.mostreiai.project.classes;

import java.util.List;
import java.util.stream.Collectors;

public class UsuariosDto {
    private Long id;
    private String nome;
    private String sobrenome;

    public UsuariosDto(Usuarios user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.sobrenome = user.getSobrenome();
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

    public static List<UsuariosDto> convert(List<Usuarios> user) {
        return user.stream().map(UsuariosDto::new).collect(Collectors.toList());
    }

}
