package com.incluwed.incluwed.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.incluwed.incluwed.classes.Places;
import com.incluwed.incluwed.classes.Postagens;
import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.dto.PostagensDto;
import com.incluwed.incluwed.dto.UsuariosDto;
import com.incluwed.incluwed.forms.PostagensForms;
import com.incluwed.incluwed.forms.UsuariosForms;
import com.incluwed.incluwed.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TelefonesRepository telefonesRepository;

    @Autowired
    private EnderecosRepository enderecosRepository;

    @Autowired
    private PostagensRepository postagensRepository;

    @Autowired
    private PlacesRepository placesRepository;

    @GetMapping
    public Page<UsuariosDto> listarTodosUsuarios(@RequestParam int pag, @RequestParam int qtd){
        
        Pageable paginacao = PageRequest.of(pag,qtd);
        Page<Usuarios> users = usuariosRepository.findAll(paginacao);
        return UsuariosDto.convert(users);
     
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDto> listaUsuarioPorId(@PathVariable long id){
        Optional<Usuarios> user = usuariosRepository.findById(id);

        if (user.isPresent()){
            return ResponseEntity.ok(new UsuariosDto(user.get()));
        }

        return ResponseEntity.notFound().build();  
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuariosDto> cadastroUsuario(@RequestBody @Validated UsuariosForms form, UriComponentsBuilder uriBuilder){
        Usuarios user = form.converter();
        usuariosRepository.save(user);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuariosDto(user));
        
    }
    
    @PostMapping("/{id}/posts")
    @Transactional
    public ResponseEntity<PostagensDto> cadastrarPostPorUsuario(@PathVariable("id") long usuario_id, @RequestBody PostagensForms form, UriComponentsBuilder uriBuilder){
        Optional<Usuarios> userCheck = usuariosRepository.findById(usuario_id);

        if (userCheck.isPresent()){
            Postagens post = form.converter(userCheck.get());
            postagensRepository.save(post);

            Pageable paginacao = PageRequest.of(0, 10);
            Page<Places> getPlace = placesRepository.findByNomeLocal(post.getNomeLocal(), paginacao);

            if ( getPlace.getNumberOfElements() == 0 ){
                Places newPlace = new Places(post.getNomeLocal(), post.getEnderecoLocal(), 1, post.getNota(), post.getNota());
                placesRepository.save(newPlace);

            }else {
                List<Places> attPlace = getPlace.toList();
                attPlace.get(0).setNumberPosts(attPlace.get(0).getNumberPosts()+1);
                attPlace.get(0).setNotaTotal(attPlace.get(0).getNotalTotal() + post.getNota());
                attPlace.get(0).setNota((float) attPlace.get(0).getNotalTotal()/attPlace.get(0).getNumberPosts());
            }

            URI uri = uriBuilder.path("/posts/{id}").buildAndExpand(form.getPost_id()).toUri();
            return ResponseEntity.created(uri).body(new PostagensDto(post));
        }
        
        
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuariosDto> updateUsuario(@PathVariable long id, @RequestBody @Validated UsuariosForms form, UriComponentsBuilder uriBuilder){
        Optional<Usuarios> user= usuariosRepository.findById(id);
        if (user.isPresent()){
            Usuarios userAtt = form.atualizaUsuario(id, usuariosRepository);

            URI uri = uriBuilder.path("/users/{id}").buildAndExpand(userAtt.getId()).toUri();
            return ResponseEntity.created(uri).body(new UsuariosDto(userAtt));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerUsuarioPorId(@PathVariable long id){
        Optional<Usuarios> optional = usuariosRepository.findById(id);
        if (optional.isPresent()){
            usuariosRepository.deleteById(id);
            telefonesRepository.deleteById(id);
            enderecosRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
        
    }
}