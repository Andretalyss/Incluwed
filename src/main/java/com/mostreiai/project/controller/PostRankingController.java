package com.mostreiai.project.controller;

import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.classes.PostagensDto;
import com.mostreiai.project.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ranking")
public class PostRankingController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping
    public Page<PostagensDto> ListaPostagens(@RequestParam int pagina) {

        Pageable paginacao = PageRequest.of(pagina, 5, Sort.by("nota").descending());
        Page<Postagens> posts = postsRepository.findAll(paginacao);
        return PostagensDto.convert(posts);
    }


}
