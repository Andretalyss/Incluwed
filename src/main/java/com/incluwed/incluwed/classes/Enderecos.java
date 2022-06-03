package com.incluwed.incluwed.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.incluwed.incluwed.interfaces.EnderecosInterface;

@Table(name="enderecos", schema="public")
@Entity
public class Enderecos implements EnderecosInterface {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long endereco_id;
    @Column(name="rua")
    private String rua;
    @Column(name="numero")
    private int numero;
    @Column(name="bairro")
    private String bairro;
    @Column(name="cidade")
    private String cidade;
    @Column(name="estado")
    private String estado;;

    public Enderecos(){}

    public long getEndereco_id() {
        return endereco_id;
    }
    
    @Override
    public String getRua() {
        return rua;
    }
    @Override
    public void setRua(String rua) {
        this.rua = rua;
    }
    @Override
    public int getNumero() {
        return numero;
    }
    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public String getBairro() {
        return bairro;
    }
    @Override
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    @Override
    public String getCidade() {
        return cidade;
    }
    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @Override
    public String getEstado() {
        return estado;
    }
    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
