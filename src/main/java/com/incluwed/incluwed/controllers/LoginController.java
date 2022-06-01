package com.incluwed.incluwed.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.naming.AuthenticationException;
import javax.transaction.Transactional;

import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.dto.TokenDto;
import com.incluwed.incluwed.forms.UsuariosLoginForm;
import com.incluwed.incluwed.forms.UsuariosResetPasswordForm;
import com.incluwed.incluwed.infrastructure.auth.TokenService;
import com.incluwed.incluwed.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    BCryptPasswordEncoder password = new BCryptPasswordEncoder();

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody UsuariosLoginForm form) throws AuthenticationException{
        UsernamePasswordAuthenticationToken dadosLogin = form.convert();
        Usuarios userId = usuariosRepository.findByEmail(form.getEmail()).get();
        
        Authentication authentication = authenticationManager.authenticate(dadosLogin);
        String token = tokenService.gerarToken(authentication);

        return ResponseEntity.ok(new TokenDto(token, "Bearer", userId.getId()));

    }

    @PostMapping("/forgot-pass")
    @Transactional
    public ResponseEntity<?> recuperacaoSenha(@RequestBody UsuariosLoginForm form) throws MessagingException, UnsupportedEncodingException{
        Optional<Usuarios> user = usuariosRepository.findByEmail(form.getEmail());
        if ( user.isPresent() ){
            MimeMessage mensagem = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensagem);

            helper.setFrom("incluwebcontato@gmail.com", "Support Incluweb");
            helper.setTo(form.getEmail());
            helper.setSubject("Redifinição de senha - Incluweb");

            String token_recup = tokenService.gerarTokenFastExpiration(form.getEmail());
            String content = "<p>Hello,</p>"
            + "<p>You have requested to reset your password.</p>"
            + "<p>Click the link below to change your password:</p>"
            + "<p><a href=\"" + "http://localhost" + "\">Change my password</a></p>"
            + "<br>"
            + "<p>Ignore this email if you do remember your password, "
            + "or you have not made the request.</p>";
            
            helper.setText(content, true);
            javaMailSender.send(mensagem);
            user.get().setToken_redif(token_recup);
            return ResponseEntity.ok(new TokenDto(token_recup, "Bearer", user.get().getId()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email não cadastrado!");
    }

    @PostMapping("/reset-pass")
    @Transactional
    public ResponseEntity<?> resetarSenha(@RequestBody UsuariosResetPasswordForm form) {
        boolean validation = tokenService.isTokenValid(form.getToken());

        if(validation){
            String email_user = tokenService.getEmailUsuario(form.getToken());
            Optional<Usuarios> user = usuariosRepository.findByEmail(email_user);
            if ( user.isPresent() && form.getToken().equals(user.get().getToken_redif())){
                String senha = password.encode(form.getSenha());
                user.get().setSenha(senha);
                user.get().setToken_redif(null);
                return ResponseEntity.status(HttpStatus.OK).body("Senha alterada com sucesso!");
            }

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token expirado!");
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}
