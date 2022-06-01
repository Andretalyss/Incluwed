package com.incluwed.incluwed.dto;

import com.incluwed.incluwed.classes.Places;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class PlacesDto {
    private long id;
    private String nomeLocal;
    private String enderecoLocal;
    private float nota;
    private LocalDateTime data;

    public PlacesDto(Places lugar){
        this.id = lugar.getId();
        this.setNomeLocal(lugar.getNomeLocal());
        this.setEnderecoLocal(lugar.getEnderecoLocal());
        this.setNota(lugar.getNota());
        this.setData(lugar.getData());
    }

    public long getId(){
        return id;
    }

    public String getNomeLocal(){
        return nomeLocal;
    }

    public String getEnderecoLocal(){
        return enderecoLocal;
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

    public void setEnderecoLocal(String enderecoLocal){
        this.enderecoLocal = enderecoLocal;
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
