package com.mostreiai.project.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="postagens", schema="public")
@Entity
public class Postagens {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="titulo")
    String titulo;

    @Column(name="conteudo")
    String msg;

    @Column(name="usuario")
    UsuariosDto user;

    @Column(name="nota")
    int nota;

    @Column(name="data")
    String data;

    public Postagens(){

    }

    public String getTitulo(){
        return titulo;
    }

    public String getMsg(){
        return msg;
    }

    public UsuariosDto getUser(){
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

    public void setUser(UsuariosDto user){
        this.user = user;
    }

    public void setNota(int nota){
        this.nota = nota;
    }

    public void setData(String data){
        this.data = data;
    }

}
