package com.mostreiai.project.controller;

import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.classes.PostagensDto;
import com.mostreiai.project.repository.PostsRepository;
import com.mostreiai.project.services.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/ranking")
public class PostRankingController {

    @Autowired
    private PostsRepository postsRepository;
    private RankService rankList;

    @GetMapping
    public HashMap<String, Float> ListaPostagens(@RequestParam int pagina) {

//      return rankList.RankList();
        List<Postagens> posts = postsRepository.findAll();
//        List<PostagensDto> posts1 = new ArrayList<>();
        HashMap<String, Float> aux = new HashMap<String, Float>();
//        posts1 = PostagensDto.convert(posts);
        for (Postagens postagensDto : posts) {
        boolean go = false;

            if (aux.isEmpty()) {
                aux.put(postagensDto.getLugar(), postagensDto.getNota());
                continue;
            }


            for (String str : aux.keySet()) {
                if (postagensDto.getLugar().contentEquals(str)) {
                    float soma = aux.get(postagensDto.getLugar()) + postagensDto.getNota();
                    aux.put(postagensDto.getLugar(), soma/2);
                    go = false;
                    break;
                }
                go = true;
            }

            if (go){
                aux.put(postagensDto.getLugar(), postagensDto.getNota());
            }

//        posts1.sort(new ComparatorNota());
        }

        return aux;
    }

}

class ComparatorNota implements Comparator<PostagensDto> {
    @Override
    public int compare(PostagensDto g1, PostagensDto g2) {
        return Float.compare(g1.getNota(), g2.getNota());
    }
}

