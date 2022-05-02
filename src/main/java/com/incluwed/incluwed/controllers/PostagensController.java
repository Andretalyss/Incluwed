package com.incluwed.incluwed.controllers;

import java.util.Optional;

import com.incluwed.incluwed.classes.Postagens;
import com.incluwed.incluwed.dto.PostagensDto;
import com.incluwed.incluwed.repository.PostagensRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostagensController {

    @Autowired
    private PostagensRepository postagensRepository;

    @GetMapping("/{id}")
    public ResponseEntity<PostagensDto> detalharPosts(@PathVariable long id) {

        Optional<Postagens> posts = postagensRepository.findById(id);
        if (posts.isPresent()){
            return ResponseEntity.ok(new PostagensDto(posts.get()));
        } 

        return ResponseEntity.notFound().build();
    }
}
