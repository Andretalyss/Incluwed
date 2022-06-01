package com.incluwed.incluwed.interfaces;

import java.time.LocalDateTime;

public interface PlacesInterface {
    public long getId();
    public String getNomeLocal();
    public String getEnderecoLocal();
    public float getNota();
    public int getNotalTotal();
    public int getNumberPosts();
    public LocalDateTime getData();


    public void setNomeLocal(String nomeLocal);
    public void setNumberPosts(int numberPosts);
    public void setEnderecoLocal(String enderecoLocal);
    public void setNota(float nota);
    public void setNotaTotal(int notaTotal);

}
