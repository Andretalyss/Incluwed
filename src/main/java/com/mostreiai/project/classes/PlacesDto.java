package com.mostreiai.project.classes;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

public class PlacesDto {
    private Long id;
    private String nomeLocal;
    private String nomeRua;
    private float nota;
    private LocalDateTime data;

    public PlacesDto(Places lugar){
        this.id = lugar.getId();
        this.setNomeLocal(lugar.getNomeLocal());
        this.setNomeRua(lugar.getNomeRua());
        this.setNota(lugar.getNota());
        this.setData(lugar.getData());
    }

    public Long getId(){
        return id;
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

    public void setNomeRua(String nomeRua){
        this.nomeRua = nomeRua;
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }

    public static Page<PlacesDto> convert(Page<Places> lugar) {
        return lugar.map(PlacesDto::new);
    }
}
