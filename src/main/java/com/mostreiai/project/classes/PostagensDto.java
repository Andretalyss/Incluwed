package com.mostreiai.project.classes;

import org.springframework.data.domain.Page;

public class PostagensDto {
    private String titulo;
    private String msg;
    private Long usuario;
    private int nota;
    private String data;

    public PostagensDto(Postagens posts){
        this.setTitulo(posts.getTitulo());
        this.setMsg(posts.getMsg());
        this.setUsuario(posts.getUsuario());
        this.setNota(posts.getNota());
        this.setData(posts.getData());
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
