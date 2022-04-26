package com.mostreiai.project.controller;

import com.mostreiai.project.classes.Usuarios;
import com.mostreiai.project.classes.UsuariosDto;
import com.mostreiai.project.forms.AttUsuariosForm;
import com.mostreiai.project.forms.UsuarioForms;
import com.mostreiai.project.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import java.net.URI;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public Page<UsuariosDto> ListaAllUser(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String email, 
            @RequestParam int pagina, @RequestParam int qtd) {

        Pageable paginacao = PageRequest.of(pagina, qtd);

                                
        if (nome != null) {
            Page<Usuarios> usuarios = usuariosRepository.findByNome(nome, paginacao);
            return UsuariosDto.convert(usuarios);
        }
        else if (email != null) {
            Page<Usuarios> usuarios = usuariosRepository.findByEmail(email, paginacao);
            return UsuariosDto.convert(usuarios);
        }
        else {
            Page<Usuarios> usuarios = usuariosRepository.findAll(paginacao);
            return UsuariosDto.convert(usuarios);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuariosDto> CadastrarUsuario(@RequestBody @Validated UsuarioForms form, UriComponentsBuilder uriBuilder) {
        CPFValidator validator = new CPFValidator();

        Usuarios usuario = form.converter();
        String cpf = usuario.getCpf();
        try {

            validator.assertValid(cpf);
            usuariosRepository.save(usuario);
        
            URI uri = uriBuilder.path("/users/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(new UsuariosDto(usuario));

        } catch (InvalidStateException e){
            return ResponseEntity.badRequest().build();
        }
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDto> detalhar(@PathVariable Long id) {

        Optional<Usuarios> user = usuariosRepository.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(new UsuariosDto(user.get()));
        } 

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuariosDto> atualizar(@PathVariable Long id, @RequestBody @Valid AttUsuariosForm form) {
        Optional<Usuarios> optional = usuariosRepository.findById(id);
        if (optional.isPresent()){
            Usuarios user = form.atualizar(id, usuariosRepository);
            return ResponseEntity.ok(new UsuariosDto(user));
        }

        return ResponseEntity.notFound().build();        
    }

    @PutMapping("/{id}/alter-pass")
    @Transactional
    public ResponseEntity<String> atualizarSenha(@PathVariable Long id, @RequestBody @Valid AttUsuariosForm form) {
        Optional<Usuarios> optional = usuariosRepository.findById(id);
        if (optional.isPresent()){
            form.atualizarSenha(id, usuariosRepository);
            return ResponseEntity.ok("Senha alterada com sucesso!");
        }

        return ResponseEntity.notFound().build();        
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Usuarios> optional = usuariosRepository.findById(id);
        if (optional.isPresent()){
            usuariosRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
        
    }
}