package com.incluwed.incluwed.forms;

import com.incluwed.incluwed.classes.Places;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class PlacesForms {
    @NotNull @NotEmpty @Length(max=20)
    private String nomeLocal;

    @NotNull @NotEmpty @Length(max=30)
    private String nomeRua;

    @NotNull @DecimalMax("5.0") @DecimalMin("0.0")
    private float nota;

    @NotNull
    private int notaTotal;

    @NotNull
    private int numberPosts;


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

    public float getNota(){
        return nota;
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

    public void setNota(float nota){
        this.nota = nota;
    }

    public Places converter(){
        return new Places(nomeLocal, nomeRua, numberPosts, nota, notaTotal);
    }

}
