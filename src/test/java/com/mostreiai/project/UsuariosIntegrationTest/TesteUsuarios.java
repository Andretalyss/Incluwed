package com.mostreiai.project.UsuariosIntegrationTest;

import static org.mockito.ArgumentMatchers.anyString;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.repository.UsuariosRepository;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class TesteUsuarios {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UsuariosRepository usuariosRepository;

    Usuarios user1 = new Usuarios((long) 1,"Teste1", "Teste1", "91919191919", "Teste1@gmail.com", "teste1234", "99999999", "58070101", "PB", "João Pessoa", "08-10-1999");
    Usuarios user2 = new Usuarios((long) 2,"Teste2", "Teste2", "91919191919", "Teste2@gmail.com", "teste1234", "99999999", "58070101", "PB", "João Pessoa", "08-10-1999");

    // TESTE GET'S

    @Test
    public void getUserAll_sucesso() throws Exception {
        Page<Usuarios> users = Mockito.mock(Page.class);
        Mockito.when(usuariosRepository.findAll(ArgumentMatchers.isA(Pageable.class))).thenReturn(users);

        mvc.perform(MockMvcRequestBuilders.get("/users?pagina=0&qtd=5")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUserAllWithoutPagination_BadRequest() throws Exception {
        
        Page<Usuarios> users = Mockito.mock(Page.class);
        Mockito.when(usuariosRepository.findAll(ArgumentMatchers.isA(Pageable.class))).thenReturn(users);

        mvc.perform(MockMvcRequestBuilders.get("/users")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getUsuarioByEmail_sucesso() throws Exception {
        Page<Usuarios> users = Mockito.mock(Page.class);
        Mockito.when(this.usuariosRepository.findByEmail(anyString(), ArgumentMatchers.isA(Pageable.class))).thenReturn(users);

        mvc.perform(MockMvcRequestBuilders.get("/users?pagina=0&qtd=5&email="+user1.getEmail())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUsuarioByEmail_notFound() throws Exception {
        Page<Usuarios> users = Mockito.mock(Page.class);
        Mockito.when(this.usuariosRepository.findByEmail(anyString(), ArgumentMatchers.isA(Pageable.class))).thenReturn(users);

        mvc.perform(MockMvcRequestBuilders.get("/users?pagina=0&qtd=5&email="+user2.getEmail())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUsuarioByNome_sucesso() throws Exception {
        Pageable paginacao = PageRequest.of(0, 5);
        Page<Usuarios> users = Mockito.mock(Page.class);
        Mockito.when(usuariosRepository.findByNome("Teste", paginacao)).thenReturn(users);

        mvc.perform(MockMvcRequestBuilders.get("/users?pagina=0&qtd=5&nome=Teste")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUsuarioById_sucesso() throws Exception {
        Mockito.when(usuariosRepository.findById(user1.getId())).thenReturn(java.util.Optional.of(user1));

        mvc.perform(MockMvcRequestBuilders.get("/users/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getUsuario_notFound() throws Exception {
        
        mvc.perform(MockMvcRequestBuilders.get("/users/4")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    // TEST POST
    @Test
    public void postUsuario_sucesso() throws Exception {
        Usuarios user = new Usuarios("Fernando", "Marques", "12295383480", "fmr@gmail.com", "12345test", "999999999", "58070510", "PB", "João Pessoa", "10-10-1999");

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON)
                                                                                .accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(user));

        
        mvc.perform(mockRequest).andExpect(MockMvcResultMatchers.status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.nome", Matchers.is(user.getNome())));
    }



    // TEST DELETE
    @Test
    public void deleteUsuarioById_sucesso() throws Exception {
        Mockito.when(usuariosRepository.findById(user1.getId())).thenReturn(Optional.of(user1));

        mvc.perform(MockMvcRequestBuilders.delete("/users/1").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
        
    }

    @Test
    public void deleteUsuarioById_notFound() throws Exception {
        Mockito.when(usuariosRepository.findById(4l)).thenReturn(null);

        mvc.perform(MockMvcRequestBuilders.delete("/users/2")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
