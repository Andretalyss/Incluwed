package com.incluwed.incluwed.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.incluwed.incluwed.interfaces.TelefonesInterface;

@Table(name="telefones", schema="public")
@Entity
public class Telefones implements TelefonesInterface {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long telefone_id;

    @Column(name="ddd")
    private int ddd;

    @Column(name="numero")
    private String numero;

    public Telefones(){}
    
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
