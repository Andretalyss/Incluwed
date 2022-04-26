package com.mostreiai.project.classes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Table(name="lugares", schema="public")
@Entity
public class Places {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome_local")
    private String nomeLocal;

    @Column(name="nome_rua")
    private String nomeRua;

    @Column(name="acesso")
    private float nota;

    @Column(name="data_cadastro")
    @CreationTimestamp
    private LocalDateTime data;

    @Column(name="numero_posts")
    private int numberPosts;

    @Column(name="nota_total")
    private float notaTotal;

    public Places(){

    }

    public Places( String nomeLocal, String nomeRua, float nota, int numberPosts, float notaTotal){
        this.nomeLocal = nomeLocal;
        this.nomeRua = nomeRua;
        this.nota = nota;
        this.numberPosts = numberPosts;
        this.notaTotal = notaTotal;
    }

    public Long getId(){
        return id;
    }

    public float getNotalTotal(){
        return notaTotal;
    }

    public int getNumberPosts(){
        return numberPosts;
    }

    public String getNomeLocal(){
        return nomeLocal;
    }

    public String getNomeRua(){
        return nomeRua;
    }

    public float getNota(){
        return nota;
    }

    public LocalDateTime getData(){
        return data;
    }

    public void setNomeLocal(String nomeLocal){
        this.nomeLocal = nomeLocal;
    }

    public void setNotaTotal(float notaTotal){
        this.notaTotal = notaTotal;
    }

    public void setNumberPosts(int numberPosts){
        this.numberPosts = numberPosts;
    }

    public void setNomeRua(String nomeRua){
        this.nomeRua = nomeRua;
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    // public void setData(Date data){
    //     this.data = data;
    // }

}
