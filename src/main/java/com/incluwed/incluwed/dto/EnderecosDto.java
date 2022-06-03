package com.incluwed.incluwed.dto;

import com.incluwed.incluwed.classes.Enderecos;

public class EnderecosDto {
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    
    public EnderecosDto(Enderecos enderecos){
        this.rua = enderecos.getRua();
        this.numero = enderecos.getNumero();
        this.bairro = enderecos.getBairro();
        this.cidade = enderecos.getCidade();
        this.estado = enderecos.getEstado();
    }

    public static EnderecosDto returnUsuarioAddressDto(Enderecos address){
        EnderecosDto addresConvert = new EnderecosDto(address);
        return addresConvert;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
