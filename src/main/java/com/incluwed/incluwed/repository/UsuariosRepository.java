package com.incluwed.incluwed.repository;

import java.util.Optional;

import com.incluwed.incluwed.classes.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
    Optional<Usuarios> findByEmail(String email);
}
