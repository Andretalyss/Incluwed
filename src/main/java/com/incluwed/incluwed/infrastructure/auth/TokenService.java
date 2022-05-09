package com.incluwed.incluwed.infrastructure.auth;

import java.util.Date;

import com.incluwed.incluwed.classes.Usuarios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${incluwed.jwt.expiration}")
    private String expiration;

    @Value("${incluwed.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication){
        Usuarios logado = (Usuarios) authentication.getPrincipal();
        Date dataHoje = new Date();
        Date dataExp = new Date(dataHoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
            .setIssuer("API Incluweb")
            .setSubject(logado.getEmail())
            .setIssuedAt(dataHoje)
            .setExpiration(dataExp)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
        

    }

    public String gerarTokenFastExpiration(String email){
        Date dataHoje = new Date();
        Date dataExp = new Date(dataHoje.getTime() + 900000);

        return Jwts.builder()
            .setIssuer("Token recup. de senha")
            .setSubject(email)
            .setIssuedAt(dataHoje)
            .setExpiration(dataExp)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch ( Exception e){
            return false;
        }
    }

    public String getEmailUsuario(String token) {
        Claims clains = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return clains.getSubject();
    }
}
