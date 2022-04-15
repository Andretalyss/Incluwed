package com.mostreiai.project.forms;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.mostreiai.project.classes.Places;
import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.repository.PostsRepository;

import org.hibernate.validator.constraints.Length;

public class AttPostsForm {
    
    @NotNull @NotEmpty @Length(max=20)
    private String titulo;

    @NotNull @NotEmpty @Length(max=20)
    private String nomeLocal;

    @NotNull @NotEmpty @Length(max=120)
    private String lugar;

    @NotNull @NotEmpty @Length(max=120)
    private String msg;

    @NotNull @DecimalMax("5.0") @DecimalMin("0.0")
    private int nota;

    public Postagens atualizar(Long id, PostsRepository postsRepository, List<Places> placeObj, int nota_old){
        Postagens posts = postsRepository.getById(id);
        posts.setNomeLocal(this.nomeLocal);
        posts.setTitulo(this.titulo);
        posts.setLugar(this.lugar);
        posts.setMsg(this.msg);
        posts.setNota(this.nota); 

                                               
        if ( nota_old != posts.getNota() ){
                                                                            
            placeObj.get(0).setNotaTotal(placeObj.get(0).getNotalTotal() - nota_old);                                                                     
            placeObj.get(0).setNotaTotal(placeObj.get(0).getNotalTotal() + posts.getNota());    
            placeObj.get(0).setNota((float) placeObj.get(0).getNotalTotal()/placeObj.get(0).getNumberPosts());
        
        }

        return posts;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getNomeLocal() {
        return nomeLocal;
    }
    // public Date getData() {
    //     return data;
    // }
    // public void setData(Date data) {
    //     this.data = data;
    // }
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
