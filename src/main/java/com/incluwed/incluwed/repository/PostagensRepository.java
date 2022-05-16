package com.incluwed.incluwed.repository;

import com.incluwed.incluwed.classes.Postagens;
import com.incluwed.incluwed.classes.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagensRepository extends JpaRepository<Postagens,Long> {
    Page<Postagens> findByNomeLocal(String nomeLocal, Pageable pagination);
    Page<Postagens> findByUsuario(Usuarios usuario, Pageable pagination);
}
