package com.incluwed.incluwed.controllers;

import javax.naming.AuthenticationException;

import com.incluwed.incluwed.dto.TokenDto;
import com.incluwed.incluwed.forms.UsuariosLoginForm;
import com.incluwed.incluwed.infrastructure.auth.TokenService;
import com.incluwed.incluwed.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    // @Autowired
    // private JavaMailSender javaMailSender;

    // @PostMapping
    // public ResponseEntity<?> loginValidation(@RequestBody UsuariosLoginForm form){
    //     Optional<Usuarios> userCheck = usuariosRepository.findByEmail(form.getEmail());
    //     if( userCheck.isPresent() ){
    //         if ( form.getSenha().equals(userCheck.get().getSenha()) ){
    //             SimpleMailMessage msg = new SimpleMailMessage();
    //             msg.setTo("atvdiniz@gmail.com");
        
    //             msg.setSubject("Usuário " + userCheck.get().getNome() + " logou no sistema.");
    //             msg.setText("Hello world");
        
    //             javaMailSender.send(msg);

    //             return ResponseEntity.ok("Credenciais válidas");
    //         }
    //     }

    //     return ResponseEntity.badRequest().body("Credenciais incorretas");
    // }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody UsuariosLoginForm form) throws AuthenticationException{
        UsernamePasswordAuthenticationToken dadosLogin = form.convert();
        
        Authentication authentication = authenticationManager.authenticate(dadosLogin);
        String token = tokenService.gerarToken(authentication);

        return ResponseEntity.ok(new TokenDto(token, "Bearer"));

    }
}
