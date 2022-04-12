package com.mostreiai.project.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int nota;

    @Column(name="data_cadastro")
    private String data;

    @Column(name="numero_posts")
    private int numberPosts;

    @Column(name="nota_total")
    private int notaTotal;

    public Places(){

    }

    public Places( String nomeLocal, String nomeRua, int nota, String data, int numberPosts, int notaTotal){
        this.nomeLocal = nomeLocal;
        this.nomeRua = nomeRua;
        this.nota = nota;
        this.data = data;
        this.numberPosts = numberPosts;
        this.notaTotal = notaTotal;
    }

    public Long getId(){
        return id;
    }

    public int getNotalTotal(){
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

    public int getNota(){
        return nota;
    }

    public String getData(){
        return data;
    }

    public void setNomeLocal(String nomeLocal){
        this.nomeLocal = nomeLocal;
    }

    public void setNotaTotal(int notaTotal){
        this.notaTotal = notaTotal;
    }

    public void setNumberPosts(int numberPosts){
        this.numberPosts = numberPosts;
    }

    public void setNomeRua(String nomeRua){
        this.nomeRua = nomeRua;
    }

    public void setNota(int nota){
        this.nota = nota;
    }

    public void setData(String data){
        this.data = data;
    }

}
