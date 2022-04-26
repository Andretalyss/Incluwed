package com.mostreiai.project.classes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Table(name="postagens", schema="public")
@Entity
public class Postagens {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="nomelocal")
    private String nomeLocal;

    @Column(name="lugar")
    private String lugar;

    @Column(name="conteudo")
    private String msg;

    @Column(name="usuario")
    private Long usuario;

    @Column(name="nota")
    private float nota;

    @Column(name="datap")
    @CreationTimestamp
    private LocalDateTime data;

    public Postagens(){

    }

    public Postagens(String titulo, String nomeLocal, String lugar, String msg, Long usuario, Float nota){
        this.titulo = titulo;
        this.nomeLocal = nomeLocal;
        this.lugar = lugar;
        this.msg = msg;
        this.usuario = usuario;
        this.nota = nota;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getMsg(){
        return msg;
    }

    public String getNomeLocal(){
        return nomeLocal;
    }

    public Long getUsuario(){
        return usuario;
    }

    public float getNota(){
        return nota;
    }

    public LocalDateTime getData(){
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

    public void setNomeLocal(String nomeLocal){
        this.nomeLocal = nomeLocal;
    }

    public void setUsuario(Long usuario){
        this.usuario  = usuario;
    }

    public void setNota(float nota){
        this.nota = nota;
    }


    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
