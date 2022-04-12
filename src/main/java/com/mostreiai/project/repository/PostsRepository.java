package com.mostreiai.project.repository;

import com.mostreiai.project.classes.Postagens;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Postagens, Long> {
    Page<Postagens> findByLugar(String lugar, Pageable paginacao);
    Page<Postagens> findByNomeLocal(String nomeLocal, Pageable paginacao);
    Page<Postagens> findByUsuario(Long usuario, Pageable paginacao);

}
