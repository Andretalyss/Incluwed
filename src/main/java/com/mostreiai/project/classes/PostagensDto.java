package com.mostreiai.project.classes;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

public class PostagensDto {
    private String titulo;
    private String nomeLocal;
    private String lugar;
    private String msg;
    private Long usuario;
    private int nota;
    private LocalDateTime data;

    public PostagensDto(Postagens posts){
        this.setTitulo(posts.getTitulo());
        this.setLugar(posts.getLugar());
        this.setNomeLocal(posts.getNomeLocal());
        this.setMsg(posts.getMsg());
        this.setUsuario(posts.getUsuario());
        this.setNota(posts.getNota());
        this.setData(posts.getData());
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario ) {
        this.usuario  = usuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public static Page<PostagensDto> convert(Page<Postagens> posts){
        return posts.map(PostagensDto::new);
    }

}
