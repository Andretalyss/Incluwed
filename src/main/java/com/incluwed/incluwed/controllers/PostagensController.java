package com.incluwed.incluwed.controllers;

import java.util.Optional;
import com.incluwed.incluwed.classes.Postagens;
import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.dto.PostagensDto;
import com.incluwed.incluwed.repository.PostagensRepository;
import com.incluwed.incluwed.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostagensController {

    @Autowired
    private PostagensRepository postagensRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;


    @GetMapping
    public Page<PostagensDto> listaPostagens(@RequestParam int pag, @RequestParam int qtd, @RequestParam(required=false) String local, 
        @RequestParam(required = false) Long usuario_id ){

        Page<Postagens> posts;
        Pageable pagination = PageRequest.of(pag, qtd);

        if( local != null ){
            posts = postagensRepository.findByNomeLocal(local, pagination);
            return PostagensDto.convertToDto(posts);
        }

        if( usuario_id != null ){
            Optional<Usuarios> usuario = usuariosRepository.findById(usuario_id);
            if(usuario.isPresent()){
                posts = postagensRepository.findByUsuario(usuario.get(), pagination);
                return PostagensDto.convertToDto(posts);

            }
        }

        posts = postagensRepository.findAll(pagination);
        return PostagensDto.convertToDto(posts);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PostagensDto> detalharPosts(@PathVariable long id) {

        Optional<Postagens> posts = postagensRepository.findById(id);
        if (posts.isPresent()){
            return ResponseEntity.ok(new PostagensDto(posts.get()));
        } 

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
    }

}
