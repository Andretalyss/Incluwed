package com.mostreiai.project.controller;

import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.classes.PostagensDto;
import com.mostreiai.project.repository.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostagensController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping
    public Page<PostagensDto> ListaPostagens(@RequestParam(required = false) String titulo,
            @RequestParam int pagina, @RequestParam int qtd) {

        Pageable paginacao = PageRequest.of(pagina, qtd);
        Page<Postagens> posts = postsRepository.findAll(paginacao);
        return PostagensDto.convert(posts);
       

    }
    
}
