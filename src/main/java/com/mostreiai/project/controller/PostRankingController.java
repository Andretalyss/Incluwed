package com.mostreiai.project.controller;

import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.classes.PostagensDto;
import com.mostreiai.project.repository.PostsRepository;
import com.mostreiai.project.services.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public class PostRankingController {

    @Autowired
    private PostsRepository postsRepository;
    private RankService rankList;

    @GetMapping
    public List<PostagensDto> ListaPostagens(@RequestParam int pagina) {

//        return rankList.RankList();
        List<Postagens> posts = postsRepository.findAll();
        List<PostagensDto> posts1 = new ArrayList<>();
        posts1 = PostagensDto.convert(posts);
        posts1.sort(new ComparatorNota());
        return posts1;
    }


}

class ComparatorNota implements Comparator<PostagensDto> {
    @Override
    public int compare(PostagensDto g1, PostagensDto g2) {
        return Integer.compare(g1.getNota(), g2.getNota());
    }
}