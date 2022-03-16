package com.mostreiai.project.controller;

import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.classes.UsuariosDto;
import com.mostreiai.project.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;


    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<UsuariosDto> ListaUser() {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        return UsuariosDto.convert(usuarios);
    }

    @RequestMapping(value="/users", method=RequestMethod.POST)
    public Usuarios CadastroUsuario(@RequestBody Usuarios usuario){
       return usuariosRepository.save(usuario);
    }
}
