package com.incluwed.incluwed.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.incluwed.incluwed.classes.Places;
import com.incluwed.incluwed.classes.Postagens;
import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.dto.PostagensDto;
import com.incluwed.incluwed.forms.PostagensForms;
import com.incluwed.incluwed.repository.PlacesRepository;
import com.incluwed.incluwed.repository.PostagensRepository;
import com.incluwed.incluwed.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserPostsController {
    
    @Autowired
    private PostagensRepository postagensRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private PlacesRepository placesRepository;

    @PostMapping("/users/{id}/posts")
    @Transactional
    public ResponseEntity<PostagensDto> cadastrarPostPorUsuario(@PathVariable("id") long usuario_id, @RequestBody PostagensForms form, UriComponentsBuilder uriBuilder){
        Optional<Usuarios> userCheck = usuariosRepository.findById(usuario_id);

        if (userCheck.isPresent()){
            Postagens post = form.converter(userCheck.get());
            Optional<Places> place = placesRepository.findByNomeLocal(post.getNomeLocal());

            if (place.get().getNumberPosts() == 0){
                Places newPlace = new Places(post.getNomeLocal(), post.getEnderecoLocal(), 1, post.getNota(), post.getNota());
                placesRepository.save(newPlace);

            }else {
                place.get().setNumberPosts(place.get().getNumberPosts() + 1);
                place.get().setNotaTotal(place.get().getNotalTotal() + post.getNota());
                place.get().setNota((float) place.get().getNotalTotal()/place.get().getNumberPosts());

            }

            postagensRepository.save(post);

            URI uri = uriBuilder.path("/posts/{id}").buildAndExpand(form.getPost_id()).toUri();
            return ResponseEntity.created(uri).body(new PostagensDto(post));
        }
        
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
    }

    @PutMapping("/users/{id}/posts/{post_id}")
    @Transactional
    public ResponseEntity<PostagensDto> atualizarPost(@PathVariable("id") long usuario_id, @PathVariable("post_id") long post_id, @RequestBody PostagensForms form, UriComponentsBuilder uBuilder){
        Optional<Postagens> postCheck = postagensRepository.findById(post_id);

        if(postCheck.isPresent()){
            Postagens post = postCheck.get();
            Optional<Places> oldPlace = placesRepository.findByNomeLocal(post.getNomeLocal());
            post = form.atualizarPost(post_id, postagensRepository);
            Optional<Places> place = placesRepository.findByNomeLocal(post.getNomeLocal());

            if (place.isPresent()){
                if (place.get().getNumberPosts() == 0){
                    Places newPlace = new Places(post.getNomeLocal(), post.getEnderecoLocal(), 1, post.getNota(), post.getNota());
                    placesRepository.save(newPlace);

                }else {
                    place.get().setNumberPosts(place.get().getNumberPosts() + 1);
                    place.get().setNotaTotal(place.get().getNotalTotal() + post.getNota());
                    place.get().setNota((float) place.get().getNotalTotal()/place.get().getNumberPosts());

                    oldPlace.get().setNumberPosts(oldPlace.get().getNumberPosts() - 1);
                    oldPlace.get().setNotaTotal(oldPlace.get().getNotalTotal() - post.getNota());
                    oldPlace.get().setNota((float) oldPlace.get().getNotalTotal()/oldPlace.get().getNumberPosts());

                }
            }


            return ResponseEntity.ok(new PostagensDto(post));
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
    }

    @DeleteMapping("/users/{id}/posts/{post_id}")
    @Transactional
    public ResponseEntity<?> removerPost(@PathVariable("post_id") long post_id){
        Optional<Postagens> postCheck = postagensRepository.findById(post_id);

        if ( postCheck.isPresent() ){
            Postagens post = postCheck.get();
            Optional<Places> place = placesRepository.findByNomeLocal(post.getNomeLocal());

            place.get().setNumberPosts(place.get().getNumberPosts() - 1);
            place.get().setNotaTotal(place.get().getNotalTotal() - post.getNota());
            place.get().setNota((float) place.get().getNotalTotal()/place.get().getNumberPosts());

            postagensRepository.deleteById(post_id);

            return ResponseEntity.ok("Postagem excluída com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
    }
}
