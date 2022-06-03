package com.incluwed.incluwed.forms;

import com.incluwed.incluwed.classes.Telefones;
import com.incluwed.incluwed.repository.TelefonesRepository;

import lombok.Getter;

@Getter
public class UsuariosAttTelForms {
    private int ddd;
    private String numero;


    public UsuariosAttTelForms(){}

    public UsuariosAttTelForms(int ddd, String numero){
        this.ddd = ddd;
        this.numero = numero;
    }

    public Telefones atualizaTelefone(long id, TelefonesRepository telefonesRepository){
        Telefones tel = telefonesRepository.getById(id);

        tel.setDdd(this.ddd);
        tel.setNumero(this.numero);

        return tel;
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
