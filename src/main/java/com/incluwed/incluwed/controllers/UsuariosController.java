package com.incluwed.incluwed.controllers;

import java.net.URI;
import java.util.Optional;
import javax.transaction.Transactional;
import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.dto.UsuariosDto;
import com.incluwed.incluwed.forms.UsuariosForms;
import com.incluwed.incluwed.forms.UsuariosSenhaForms;
import com.incluwed.incluwed.repository.EnderecosRepository;
import com.incluwed.incluwed.repository.TelefonesRepository;
import com.incluwed.incluwed.repository.UsuariosRepository;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
@EnableWebMvc
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TelefonesRepository telefonesRepository;

    @Autowired
    private EnderecosRepository enderecosRepository;

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

    
    @PutMapping("/{id}/pass")
    @Transactional
    public ResponseEntity<String> updateSenhaUsuario(@PathVariable("id") long id, @RequestBody @Validated UsuariosSenhaForms form ){
        Optional<Usuarios> userCheck = usuariosRepository.findById(id);
        if (userCheck.isPresent()){
            if ( userCheck.get().getSenha().equals(form.getSenha_velha())){
                form.atualizaSenhaUsuario(id, usuariosRepository);
                return ResponseEntity.ok("Senha alterada com sucesso.");
            }
           
            return ResponseEntity.badRequest().body("Senha atual não é válida.");
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
            return ResponseEntity.ok("Usuário: " + optional.get().getId() +  " deletado com sucesso!");
        }
        
        return ResponseEntity.notFound().build();
        
    }

}