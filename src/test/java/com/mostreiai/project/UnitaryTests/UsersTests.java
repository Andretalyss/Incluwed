package com.mostreiai.project.UnitaryTests;

import com.mostreiai.project.classes.Usuarios;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UsersTests {

    Usuarios user1 = new Usuarios();

    @Test
    public void TestSetterNomeUsuario(){
        user1.setNome("André");
        String nome = user1.getNome();

        assertEquals(nome, user1.getNome());
    }

    @Test
    public void TestSetterCpf(){
        user1.setCpf("23333333333");
        String cpf = user1.getCpf();

        assertEquals(cpf, user1.getCpf());
    }

    @Test
    public void TestSetterSobrenomeUsuario(){
        user1.setSobrenome("Diniz");
        String sobrenome = user1.getSobrenome();

        assertEquals(sobrenome, user1.getSobrenome());
    }

    @Test
    public void TestSetterSenha(){
        user1.setSenha("12345abc");
        String senha = user1.getSenha();

        assertEquals(senha, user1.getSenha());
    }

    @Test
    public void TestSetterTelefone(){
        user1.setNome("238888888");
        String telefone = user1.getTelefone();

        assertEquals(telefone, user1.getTelefone());
    }

    @Test
    public void TestSetterCEP(){
        user1.setCep("André");
        String cep = user1.getCep();

        assertEquals(cep, user1.getCep());
    }

    @Test
    public void TestSetterEstado(){
        user1.setEstado("PB");
        String estado = user1.getEstado();

        assertEquals(estado, user1.getEstado());
    }

    @Test
    public void TestSetterCidade(){
        user1.setCidade("Mangabeira");
        String cidade = user1.getCidade();

        assertEquals(cidade, user1.getCidade());
    }

    @Test
    public void TestSetterNascimento(){
        user1.setNascimento("12/12/12");
        String nascimento = user1.getNascimento();

        assertEquals(nascimento, user1.getNascimento());
    }

}
