package com.incluwed.incluwed.interfaces;

public interface UsuariosInterface {
    public long getId();
    public String getNome();
    public String getSobrenome();
    public String getCpf();
    public String getEmail();
    public String getSenha();
    public String getNascimento();

    public void setNome(String nome);
    public void setSobrenome(String sobrenome);
    public void setCpf(String cpf);
    public void setEmail(String email);
    public void setSenha(String senha);
    public void setNascimento(String nascimento);
}
