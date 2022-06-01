package com.incluwed.incluwed.classes;

import com.incluwed.incluwed.interfaces.PlacesInterface;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="lugares", schema = "public")
@Entity
public class Places implements PlacesInterface {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="n_local")
    private String nomeLocal;

    @Column(name="endereco")
    private String enderecoLocal;

    @Column(name="data_cadastro")
    @CreationTimestamp
    private LocalDateTime data;

    @Column(name="numero_posts")
    private int numberPosts;

    @Column(name="acesso")
    private float nota;

    @Column(name="nota_total")
    private int notaTotal;

    public Places(){};

    public Places( String nomeLocal, String enderecoLocal, int numberPosts, float nota, int notaTotal){
        this.nomeLocal = nomeLocal;
        this.enderecoLocal = enderecoLocal;
        this.numberPosts = numberPosts;
        this.nota = nota;
        this.notaTotal = notaTotal;
    }

    @Override
    public long getId(){
        return id;
    }
    @Override
    public String getNomeLocal(){
        return nomeLocal;
    };

    @Override
    public String getEnderecoLocal(){
        return enderecoLocal;
    };

    @Override
    public float getNota(){
        return nota;
    };

    @Override
    public int getNotalTotal(){
        return notaTotal;
    };

    @Override
    public int getNumberPosts(){
        return numberPosts;
    };

    @Override
    public LocalDateTime getData(){
        return data;
    };

    @Override
    public void setNomeLocal(String nomeLocal){
        this.nomeLocal=nomeLocal;
    };

    @Override
    public void setNumberPosts(int numberPosts){
        this.numberPosts=numberPosts;
    };

    @Override
    public void setEnderecoLocal(String enderecoLocal){
        this.enderecoLocal=enderecoLocal;
    };

    @Override
    public void setNota(float nota){
        this.nota=nota;
    };

    @Override
    public void setNotaTotal(int notaTotal){
        this.notaTotal=notaTotal;
    };

}
