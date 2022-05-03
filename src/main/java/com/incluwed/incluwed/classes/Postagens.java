package com.incluwed.incluwed.classes;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.incluwed.incluwed.interfaces.PostagensInterface;

import org.hibernate.annotations.CreationTimestamp;

@Table(name="postagens", schema="public")
@Entity
public class Postagens implements PostagensInterface {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="n_local")
    private String nomeLocal;

    @Column(name="endereco")
    private String enderecoLocal;

    @Column(name="texto")
    private String texto;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="usuario_id")
    private Usuarios usuario;

    @Column(name="nota")
    private int nota;

    @Column(name="data_criacao")
    @CreationTimestamp
    private LocalDateTime data;


    public Postagens(String titulo, String nomeLocal, String enderecoLocal, String texto, Usuarios usuario, int nota) {
        this.titulo = titulo;
        this.nomeLocal = nomeLocal;
        this.enderecoLocal = enderecoLocal;
        this.texto = texto;
        this.usuario = usuario;
        this.nota = nota;
    }


    public Postagens(){}

    public long getPost_id(){
        return post_id;
    }

    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getNomeLocal() {
        return nomeLocal;
    }


    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }


    public String getEnderecoLocal() {
        return enderecoLocal;
    }


    public void setEnderecoLocal(String enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }


    public String getTexto() {
        return texto;
    }


    public void setTexto(String texto) {
        this.texto = texto;
    }


    public Usuarios getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }


    public int getNota() {
        return nota;
    }


    public void setNota(int nota) {
        this.nota = nota;
    }


    public LocalDateTime getData() {
        return data;
    }


    public void setData(LocalDateTime data) {
        this.data = data;
    }


    
}
