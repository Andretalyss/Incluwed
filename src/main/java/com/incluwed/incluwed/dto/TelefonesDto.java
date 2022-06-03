package com.incluwed.incluwed.dto;

import com.incluwed.incluwed.classes.Telefones;

public class TelefonesDto {
    private int ddd;
    private String numero;
    
    public TelefonesDto(Telefones telefone){
        this.ddd = telefone.getDdd();
        this.numero = telefone.getNumero();
    }
    
    public static TelefonesDto returnUsuarioTelDto(Telefones tel){
        TelefonesDto telConvert = new TelefonesDto(tel);
        return telConvert;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
