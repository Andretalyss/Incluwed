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
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="lugar")
    private String lugar;

    @Column(name="conteudo")
    private String msg;

    @Column(name="usuario")
    private Long usuario;

    @Column(name="nota")
    private float nota;

    @Column(name="datap")
    private String data;

    public Postagens(){

    }

    public Postagens(String titulo, String lugar, String msg, Long usuario, Integer nota, String data){
        this.titulo = titulo;
        this.lugar = lugar;
        this.msg = msg;
        this.usuario = usuario;
        this.nota = nota;
        this.data = data;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getMsg(){
        return msg;
    }

    public Long getUsuario(){
        return usuario;
    }

    public float getNota(){
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

    public void setUsuario(Long usuario){
        this.usuario  = usuario;
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
