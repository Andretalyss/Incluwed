package com.mostreiai.project.repository;

import java.util.List;

import com.mostreiai.project.classes.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long>{

    List<Usuarios> findByNome(String nome);
}
