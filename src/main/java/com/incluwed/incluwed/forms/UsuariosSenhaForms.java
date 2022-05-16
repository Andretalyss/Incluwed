package com.incluwed.incluwed.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.repository.UsuariosRepository;

public class UsuariosSenhaForms {
    @NotNull @NotEmpty @Size(min=8, max=12)
    private String senha_nova;

    @NotNull @NotEmpty
    private String senha_velha;

    public UsuariosSenhaForms(){}
    
    public void atualizaSenhaUsuario(long id, UsuariosRepository usuariosRepository){
        Usuarios usuario = usuariosRepository.getById(id);
        usuario.setSenha(this.senha_nova);
    }

    public String getSenha_nova() {
        return senha_nova;
    }

    public void setSenha_nova(String senha_nova) {
        this.senha_nova = senha_nova;
    }

    public String getSenha_velha() {
        return senha_velha;
    }

    public void setSenha_velha(String senha_velha) {
        this.senha_velha = senha_velha;
    }


}
