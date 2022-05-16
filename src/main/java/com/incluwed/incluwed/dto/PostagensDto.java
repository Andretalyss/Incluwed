package com.incluwed.incluwed.dto;

import java.time.LocalDateTime;
import com.incluwed.incluwed.classes.Postagens;
import org.springframework.data.domain.Page;

public class PostagensDto {
    private String post_titulo;
    private String post_nomeLocal;
    private String post_enderecoLocal;
    private String post_texto;
    private int post_nota;
    private UsuariosDto usuarios;
    private LocalDateTime post_data;

    public PostagensDto(Postagens posts){
        this.post_titulo = posts.getTitulo();
        this.post_nomeLocal = posts.getNomeLocal();
        this.post_enderecoLocal = posts.getEnderecoLocal();
        this.post_texto = posts.getTexto();
        this.post_nota = posts.getNota();
        this.post_data = posts.getData();
        this.usuarios = UsuariosDto.returnUsuarioDto(posts.getUsuario());
    }

    public static Page<PostagensDto> convertToDto(Page<Postagens> posts){
        return posts.map(PostagensDto::new);
    }

    public String getPost_titulo() {
        return post_titulo;
    }
    public void setPost_titulo(String post_titulo) {
        this.post_titulo = post_titulo;
    }
    public String getPost_nomeLocal() {
        return post_nomeLocal;
    }
    public void setPost_nomeLocal(String post_nomeLocal) {
        this.post_nomeLocal = post_nomeLocal;
    }
    public String getPost_enderecoLocal() {
        return post_enderecoLocal;
    }
    public void setPost_enderecoLocal(String post_enderecoLocal) {
        this.post_enderecoLocal = post_enderecoLocal;
    }
    public String getPost_texto() {
        return post_texto;
    }
    public void setPost_texto(String post_texto) {
        this.post_texto = post_texto;
    }
    public int getPost_nota() {
        return post_nota;
    }
    public void setPost_nota(int post_nota) {
        this.post_nota = post_nota;
    }
    public LocalDateTime getPost_data_criacao() {
        return post_data;
    }
    public void setPost_data_criacao(LocalDateTime post_data) {
        this.post_data= post_data;
    }

    public UsuariosDto getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosDto usuarios) {
        this.usuarios = usuarios;
    }


}
