package com.mostreiai.project.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="postagens", schema="public")
@Entity
public class Postagens {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="conteudo")
    private String msg;

    @ManyToOne
    private Usuarios user;

    @Column(name="nota")
    private int nota;

    @Column(name="datap")
    private String data;

    public Postagens(){

    }

    public String getTitulo(){
        return titulo;
    }

    public String getMsg(){
        return msg;
    }

    public Usuarios getUser(){
        return user;
    }

    public int getNota(){
        return nota;
    }

    public String getData(){
        return data;
    }

    public Long getId(){
        return id;
    }


    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public void setUser(Usuarios user){
        this.user = user;
    }

    public void setNota(int nota){
        this.nota = nota;
    }

    public void setData(String data){
        this.data = data;
    }

}
