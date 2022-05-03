package com.incluwed.incluwed.interfaces;

import java.time.LocalDateTime;
import com.incluwed.incluwed.classes.Usuarios;

public interface PostagensInterface {
    public String getTitulo();
    public String getNomeLocal();
    public String getEnderecoLocal();
    public String getTexto();
    public Usuarios getUsuario();
    public int getNota();
    public LocalDateTime getData();
}
