package com.mostreiai.project.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.mostreiai.project.classes.Places;
import com.mostreiai.project.classes.Postagens;
import com.mostreiai.project.classes.PostagensDto;
import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.forms.AttPostsForm;
import com.mostreiai.project.forms.PostagensForms;
import com.mostreiai.project.repository.PlacesRepository;
import com.mostreiai.project.repository.PostsRepository;
import com.mostreiai.project.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/posts")
public class PostagensController {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private PlacesRepository placesRepository;


    @GetMapping
    public Page<PostagensDto> ListaPostagens(@RequestParam(required = false) String nomelocal,
        @RequestParam(required = false) String lugar, @RequestParam(required=false) Long usuario_id,
            @RequestParam int pagina, @RequestParam int qtd) {

        Pageable paginacao = PageRequest.of(pagina, qtd);


        if (nomelocal != null){
            Page<Postagens> posts = postsRepository.findByNomeLocal(nomelocal, paginacao);
            return PostagensDto.convert(posts);
        }

        if (lugar != null){
            Page<Postagens> posts = postsRepository.findByLugar(lugar, paginacao);
            return PostagensDto.convert(posts);
        }

        if ( usuario_id != null){
            Page<Postagens> posts = postsRepository.findByUsuario(usuario_id, paginacao);
            return PostagensDto.convert(posts);
        }

        Page<Postagens> posts = postsRepository.findAll(paginacao);
        return PostagensDto.convert(posts);
       
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<PostagensDto> CadastrarPosts(@PathVariable("id") Long usuario_id, @RequestBody @Valid PostagensForms form, UriComponentsBuilder uriBuilder) {
        
        Optional<Usuarios> userCheck = usuariosRepository.findById(usuario_id);

        if ( userCheck.isPresent()){
            Postagens posts = form.converter(usuario_id);
            postsRepository.save(posts);

            Pageable paginacao = PageRequest.of(0, 10);
            Page<Places> getPlace = placesRepository.findByNomeLocal(posts.getNomeLocal(), paginacao);

            if ( getPlace.getNumberOfElements() == 0 ){
                Places newPlace = new Places(posts.getNomeLocal(), posts.getLugar(), posts.getNota(), posts.getData(), 1, posts.getNota());
                placesRepository.save(newPlace);
            }else {
                List<Places> attPlace = getPlace.toList();
                attPlace.get(0).setNumberPosts(attPlace.get(0).getNumberPosts()+1); 
                attPlace.get(0).setNotaTotal(attPlace.get(0).getNotalTotal() + posts.getNota());
                attPlace.get(0).setNota(attPlace.get(0).getNotalTotal()/attPlace.get(0).getNumberPosts());
            }

            URI uri = uriBuilder.path("/post/{id}").buildAndExpand(posts.getId()).toUri();
            return ResponseEntity.created(uri).body(new PostagensDto(posts));     
        }

        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PostagensDto> detalharPosts(@PathVariable Long id) {

        Optional<Postagens> posts = postsRepository.findById(id);
        if (posts.isPresent()){
            return ResponseEntity.ok(new PostagensDto(posts.get()));
        } 

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PostagensDto> atualizar(@PathVariable Long id, @RequestBody @Valid AttPostsForm form) {
        Optional<Postagens> optional = postsRepository.findById(id);
        if (optional.isPresent()){

            Postagens posts = optional.get();
            Pageable paginacao = PageRequest.of(0, 10);
            Page<Places> getPlace = placesRepository.findByNomeLocal(posts.getNomeLocal(), paginacao);

            List<Places> attPlace = getPlace.toList();
            posts = form.atualizar(id, postsRepository, attPlace);

            return ResponseEntity.ok(new PostagensDto(posts));
        }

        return ResponseEntity.notFound().build();        
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerPost(@PathVariable Long id){
        Optional<Postagens> optional = postsRepository.findById(id);
        if (optional.isPresent()){
            
            Postagens posts = optional.get();
            Pageable paginacao = PageRequest.of(0, 10);
            Page<Places> getPlace = placesRepository.findByNomeLocal(posts.getNomeLocal(), paginacao);

            List<Places> attPlace = getPlace.toList();
            attPlace.get(0).setNumberPosts(attPlace.get(0).getNumberPosts()-1); 
            attPlace.get(0).setNotaTotal(attPlace.get(0).getNotalTotal() - posts.getNota());
            attPlace.get(0).setNota(attPlace.get(0).getNotalTotal()/attPlace.get(0).getNumberPosts());
        
            postsRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
        
    }
}
