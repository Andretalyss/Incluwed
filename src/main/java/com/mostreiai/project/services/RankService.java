package com.mostreiai.project.services;

import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.classes.PostagensDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mostreiai.project.repository.PostsRepository;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class RankService {
    @Autowired
    private PostsRepository postsRepository;

    public List<PostagensDto> RankList() {
        //List<String> rankList = new ArrayList<>();
        List<Postagens> posts = postsRepository.findAll();
//        List<PostagensDto> posts1 = new ArrayList<>();
//        posts1 = PostagensDto.convert(posts);
//        posts1.sort(new ComparatorNota());
        return PostagensDto.convert(posts);
    }

}

class ComparatorNota implements Comparator<PostagensDto> {
    @Override
    public int compare(PostagensDto g1, PostagensDto g2) {
        return Integer.compare(g1.getNota(), g2.getNota());
    }
}