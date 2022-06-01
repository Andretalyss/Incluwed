package com.incluwed.incluwed.dto;

public class TokenDto {
    private String token;
    private String tipo;
    private long id;

    public TokenDto(String token, String tipo, long id){
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
