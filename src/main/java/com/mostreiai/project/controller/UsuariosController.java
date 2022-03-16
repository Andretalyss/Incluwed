package com.mostreiai.project.controller;

import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.classes.UsuariosDto;
import com.mostreiai.project.forms.UsuarioForms;
import com.mostreiai.project.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;


    @GetMapping
    public List<UsuariosDto> ListaUser(String nome) {
        if (nome == null) {
            List<Usuarios> usuarios = usuariosRepository.findAll();
            return UsuariosDto.convert(usuarios);
        }else {
            List<Usuarios> usuarios = usuariosRepository.findByNome(nome);
            return UsuariosDto.convert(usuarios);
        }
    }

    @PostMapping
    public ResponseEntity<UsuariosDto> CadastrarUsuario(@RequestBody @Validated UsuarioForms form, UriComponentsBuilder uriBuilder) {
        Usuarios usuario = form.converter();
        usuariosRepository.save(usuario);
        
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuariosDto(usuario));
        
    }
}
