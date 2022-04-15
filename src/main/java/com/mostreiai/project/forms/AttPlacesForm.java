package com.mostreiai.project.forms;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.mostreiai.project.classes.Places;
import com.mostreiai.project.repository.PlacesRepository;

import org.hibernate.validator.constraints.Length;

public class AttPlacesForm {
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

    public Places atualizar(Long id, PlacesRepository placesRepository){
        Places places = placesRepository.getById(id);
        places.setNomeLocal(this.nomeLocal);
        places.setNomeRua(this.nomeRua);
        places.setNota(this.nota);
        places.setNotaTotal(this.notaTotal);
        places.setNumberPosts(this.numberPosts);

        return places;
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
}
