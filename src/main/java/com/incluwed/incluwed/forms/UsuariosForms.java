package com.incluwed.incluwed.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.incluwed.incluwed.classes.Enderecos;
import com.incluwed.incluwed.classes.Telefones;
import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.repository.UsuariosRepository;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuariosForms {
    
    @NotNull @NotEmpty @Length(max = 12)
    private String nome;

    @NotNull @NotEmpty @Length(max = 30)
    private String sobrenome;

    @NotNull @NotEmpty
    private String cpf;
    
    @NotNull @NotEmpty @Length(max = 25)
    private String email;

    @NotNull @NotEmpty @Length(max = 12)
    private String nascimento;

    @NotNull @NotEmpty @Size(min=8, max=12)
    private String senha;

    private Enderecos endereco;

    private Telefones telefone;

    public UsuariosForms(String nome, String sobrenome,String cpf, String email,String senha, String nascimento, Enderecos endereco, Telefones telefone){

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.telefone = telefone;

    }

    public Usuarios converter() {
        return new Usuarios(nome, sobrenome, cpf, email, senha, nascimento, endereco, telefone);
    }

    public Usuarios atualizaUsuario(long id, UsuariosRepository usuariosRepository){
        Usuarios user = usuariosRepository.getById(id);
        
        user.setNome(this.nome);
        user.setSobrenome(this.sobrenome);
        user.setEmail(this.email);
        user.setCpf(this.cpf);
        user.setTelefone(telefone);
        user.setEndereco(endereco);
        user.setNascimento(this.nascimento);

        return user;
    }

}

