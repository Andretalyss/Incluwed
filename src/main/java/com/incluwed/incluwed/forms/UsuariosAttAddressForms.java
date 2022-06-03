package com.incluwed.incluwed.forms;

import com.incluwed.incluwed.classes.Enderecos;
import com.incluwed.incluwed.repository.EnderecosRepository;

import lombok.Getter;

@Getter
public class UsuariosAttAddressForms {
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;

    public UsuariosAttAddressForms(){

    }
    
    public UsuariosAttAddressForms(String rua, int numero, String bairro, String cidade, String estado){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Enderecos atualizaAddress(long id, EnderecosRepository enderecosRepository){
        Enderecos address = enderecosRepository.getById(id);

        address.setRua(this.rua);
        address.setNumero(this.numero);
        address.setBairro(this.bairro);
        address.setCidade(this.cidade);
        address.setEstado(this.estado);

        return address;
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
