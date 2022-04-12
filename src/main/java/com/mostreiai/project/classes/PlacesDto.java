package com.mostreiai.project.classes;

import org.springframework.data.domain.Page;

public class PlacesDto {
    private Long id;
    private String nomeLocal;
    private String nomeRua;
    private int nota;
    private String data;

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

    public int getNota(){
        return nota;
    }

    public String getData(){
        return data;
    }

    public void setNomeLocal(String nomeLocal){
        this.nomeLocal = nomeLocal;
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

    public static Page<PlacesDto> convert(Page<Places> lugar) {
        return lugar.map(PlacesDto::new);
    }
}
