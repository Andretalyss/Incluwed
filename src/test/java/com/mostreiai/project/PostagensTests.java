package com.mostreiai.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.repository.PostsRepository;
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

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class PostagensTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private PostsRepository postsRepository;

    Postagens post1 = new Postagens("Teste1", "Shopping", "rua josefa taveira", "paia",(long) 1, (float)2);
    Postagens post2 = new Postagens("Teste2", "CI", "rua josefa taveira", "massa",(long) 1, (float)5);

    // TESTE GET'S

    @Test
    public void getPostsAll_sucesso() throws Exception {
        Page<Postagens> posts = Mockito.mock(Page.class);
        Mockito.when(postsRepository.findAll(ArgumentMatchers.isA(Pageable.class))).thenReturn(posts);

        mvc.perform(MockMvcRequestBuilders.get("/users?pagina=0&qtd=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getPostsAllWithoutPagination_BadRequest() throws Exception {

        Page<Postagens> posts = Mockito.mock(Page.class);
        Mockito.when(postsRepository.findAll(ArgumentMatchers.isA(Pageable.class))).thenReturn(posts);

        mvc.perform(MockMvcRequestBuilders.get("/posts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getPostsByLugar_sucesso() throws Exception {
        Page<Postagens> posts = Mockito.mock(Page.class);
        Mockito.when(this.postsRepository.findByLugar(anyString(), ArgumentMatchers.isA(Pageable.class))).thenReturn(posts);

        mvc.perform(MockMvcRequestBuilders.get("/posts?pagina=0&qtd=5&lugar="+post1.getLugar())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getPostsByLugar_notFound() throws Exception {
        Page<Postagens> posts = Mockito.mock(Page.class);
        Mockito.when(this.postsRepository.findByLugar(anyString(), ArgumentMatchers.isA(Pageable.class))).thenReturn(posts);

        mvc.perform(MockMvcRequestBuilders.get("/posts?pagina=0&qtd=5&lugar="+post2.getLugar())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getPostsByNomeLocal_sucesso() throws Exception {
        Pageable paginacao = PageRequest.of(0, 5);
        Page<Postagens> posts = Mockito.mock(Page.class);
        Mockito.when(postsRepository.findByNomeLocal("Shopping", paginacao)).thenReturn(posts);

        mvc.perform(MockMvcRequestBuilders.get("/posts?pagina=0&qtd=5&nome=Shopping")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @org.junit.jupiter.api.Test
//    public void getUsuarioById_sucesso() throws Exception {
//        Mockito.when(usuariosRepository.findById(user1.getId())).thenReturn(java.util.Optional.of(user1));
//
//        mvc.perform(MockMvcRequestBuilders.get("/users/1")
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
//
//    }

    @Test
    public void getPosts_notFound() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/posts/4")
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
    public void deletePostsById_sucesso() throws Exception {
        Mockito.when(postsRepository.findById(post1.getId())).thenReturn(Optional.of(post1));

        mvc.perform(MockMvcRequestBuilders.delete("/posts/1").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void deletePostsById_notFound() throws Exception {
        Mockito.when(postsRepository.findById(4l)).thenReturn(null);

        mvc.perform(MockMvcRequestBuilders.delete("/posts/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
