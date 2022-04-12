package com.mostreiai.project.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.mostreiai.project.classes.Postagens;
import org.hibernate.validator.constraints.Length;

public class PostagensForms {

    @NotNull @NotEmpty @Length(max=20)
    private String titulo;

    @NotNull @NotEmpty @Length(max=20)
    private String nomeLocal;

    @NotNull @NotEmpty @Length(max=120)
    private String lugar;

    @NotNull @NotEmpty @Length(max=120)
    private String msg;

    private Long usuario;

    private int nota;

    @NotNull @NotEmpty @Length(max=10)
    private String data;

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

    public Long getUsuario() {
        return usuario;
    }

    public void setUser(Long usuario ) {
        this.usuario  = usuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitulo() {
        return titulo;
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

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public Postagens converter(Long usuario ) {
        return new Postagens(titulo, nomeLocal, lugar, msg, usuario, nota, data);
    }

}
