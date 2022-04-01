package com.mostreiai.project.repository;

import com.mostreiai.project.classes.Postagens;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Postagens, Long> {
    Page<Postagens> findByTitulo(String titulo, Pageable paginacao);
    Page<Postagens> findByUsuario(Long usuario, Pageable paginacao);
}
