package com.mostreiai.project.UnitaryTests;

import com.mostreiai.project.classes.Postagens;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class PostagensTests {
        //Teste de  Getters e Setters
        Postagens post = new Postagens();

        @Test
        public void TestSetterTitulo(){
            post.setTitulo("Teste1");
            String titulo = post.getTitulo();

            assertEquals(titulo, post.getTitulo());
        }
        @Test
        public void TestSetterNomeLocal(){
            post.setNomeLocal("CI");
            String nomeLocal = post.getNomeLocal();

            assertEquals(nomeLocal, post.getNomeLocal());
        }

        @Test
        public void TestSetterLugar(){
            post.setLugar("Josefa Taveira");
            String lugar = post.getLugar();

            assertEquals(lugar, post.getLugar());
        }
        @Test
        public void TestSetterMsg(){
            post.setMsg("CI");
            String msg = post.getMsg();

            assertEquals(msg, post.getMsg());
        }
        @Test
        public void TestSetterUserId(){
            post.setUsuario(2);
            long userId = post.getUsuario();

            assertEquals(userId, post.getUsuario());
        }
        @Test
        public void TestSetterNota(){
            post.setNota(5f);
            float nota = post.getNota();

            assertEquals(nota, post.getNota(), 0.002f);
        }

}
