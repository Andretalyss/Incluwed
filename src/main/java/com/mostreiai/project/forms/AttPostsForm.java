package com.mostreiai.project.forms;

import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.repository.PostsRepository;

public class AttPostsForm {
    private String titulo;
    private String msg;
    private int nota;
    private String data;

    public Postagens atualizar(Long id, PostsRepository postsRepository){
        Postagens posts = postsRepository.getById(id);
        posts.setTitulo(this.titulo);
        posts.setMsg(this.msg);
        posts.setNota(this.nota);
        posts.setData(this.data);

        return posts;
    }

    public String getTitulo() {
        return titulo;
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
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    
}
