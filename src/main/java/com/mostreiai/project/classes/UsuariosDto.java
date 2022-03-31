package com.mostreiai.project.classes;
import org.springframework.data.domain.Page;

public class UsuariosDto {
    private Long id;
    private String nome;
    private String email;
    private String estado;
    private String cidade;

    public UsuariosDto(Usuarios user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.estado = user.getEstado();
        this.cidade = user.getCidade();
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }
    
    public String getEmail(){
        return email;
    }

    public String getEstado(){
        return estado;
    }

    public String getCidade(){
        return cidade;
    }

    public static Page<UsuariosDto> convert(Page<Usuarios> user) {
        return user.map(UsuariosDto::new);
    }

}
