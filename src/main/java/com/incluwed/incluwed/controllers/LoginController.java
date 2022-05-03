package com.incluwed.incluwed.controllers;

import java.util.Optional;

import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.forms.UsuariosLoginForm;
import com.incluwed.incluwed.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping
    public ResponseEntity<?> loginValidation(@RequestBody UsuariosLoginForm form){
        Optional<Usuarios> userCheck = usuariosRepository.findByEmail(form.getEmail());
        if( userCheck.isPresent() ){
            if ( form.getSenha().equals(userCheck.get().getSenha()) ){
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo("rafaelvlfarias@gmail.com");
        
                msg.setSubject("Usuário " + userCheck.get().getNome() + " logou no sistema.");
                msg.setText("Hello world");
        
                javaMailSender.send(msg);

                return ResponseEntity.ok("Credenciais válidas");
            }
        }

        return ResponseEntity.badRequest().body("Credenciais incorretas");
    }



}
