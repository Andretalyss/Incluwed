package com.incluwed.incluwed.infrastructure.auth;

import java.util.Optional;

import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuarios> user = usuariosRepository.findByEmail(username);
        if ( user.isPresent() ){
            return user.get();
        }
        
        throw new UsernameNotFoundException("Dados inválidos");
    }
}
