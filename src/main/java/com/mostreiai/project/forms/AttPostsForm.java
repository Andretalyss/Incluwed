package com.mostreiai.project.forms;

import java.util.List;

import com.mostreiai.project.classes.Places;
import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.repository.PostsRepository;

public class AttPostsForm {
    private String titulo;
    private String nomeLocal;
    private String lugar;
    private String msg;
    private int nota;
    private String data;

    public Postagens atualizar(Long id, PostsRepository postsRepository, List<Places> placeObj){
        Postagens posts = postsRepository.getById(id);
        posts.setNomeLocal(this.nomeLocal);
        posts.setTitulo(this.titulo);
        posts.setLugar(this.lugar);
        posts.setMsg(this.msg);
        posts.setData(this.data);
        posts.setNota(this.nota); 

                                               
        if ( placeObj.get(0).getNota() != posts.getNota() ){

                                                                                     
            placeObj.get(0).setNotaTotal(placeObj.get(0).getNotalTotal() - placeObj.get(0).getNota());  

                                                                               
            placeObj.get(0).setNotaTotal(placeObj.get(0).getNotalTotal() + posts.getNota());    


            posts.setNota(placeObj.get(0).getNotalTotal()/placeObj.get(0).getNumberPosts());
        
        }

        return posts;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getNomeLocal() {
        return nomeLocal;
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
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    
}
