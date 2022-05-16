package com.incluwed.incluwed.infrastructure.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.repository.UsuariosRepository;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class AutenticacaoFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuariosRepository usuariosRepository;

    public AutenticacaoFilter(TokenService tokenService, UsuariosRepository usuariorRepository){
        this.tokenService = tokenService;
        this.usuariosRepository = usuariorRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValid(token);

        if(valido){
            autenticarCliente(token);
        }

        filterChain.doFilter(request, response);
        
    }

    private void autenticarCliente(String token) {
       String email = tokenService.getEmailUsuario(token);
       Usuarios usuario = usuariosRepository.findByEmail(email).get();
       UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
       SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer")){
            return null;
        }

        return token.substring(7, token.length());
    }
}
