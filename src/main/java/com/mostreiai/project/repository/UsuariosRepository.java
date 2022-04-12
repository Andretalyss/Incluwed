package com.mostreiai.project.repository;

import com.mostreiai.project.classes.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long>{

    Page<Usuarios> findByNome(String nome, Pageable paginacao);
    Page<Usuarios> findByEmail(String email, Pageable paginacao);
}
