package com.mostreiai.project.UnitaryTests;

import com.mostreiai.project.classes.Places;
import com.mostreiai.project.classes.Postagens;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlacesTests {
    //Teste de  Getters e Setters
    Places place = new Places();

    @Test
    public void TestSetterTitulo(){
        place.setNomeLocal("CI");
        String nomeLocal = place.getNomeLocal();

        assertEquals(nomeLocal, place.getNomeLocal());
    }
    @Test
    public void TestSetterNomeRua(){
        place.setNomeRua("Josefa Taveira");
        String nomeRua = place.getNomeRua();

        assertEquals(nomeRua, place.getNomeRua());
    }

    @Test
    public void TestSetterNota(){
        place.setNota(3f);
        float nota = place.getNota();

        assertEquals(nota, place.getNota(), 0.002f);
    }
    @Test
    public void TestSetterNumPost(){
        place.setNumberPosts(3);
        int numberPosts = place.getNumberPosts();

        assertEquals(numberPosts, place.getNumberPosts());
    }

    @Test
    public void TestSetterNotaTotal(){
        place.setNota(12f);
        float notaTotal = place.getNotalTotal();

        assertEquals(notaTotal, place.getNotalTotal(), 0.002f);
    }

}
