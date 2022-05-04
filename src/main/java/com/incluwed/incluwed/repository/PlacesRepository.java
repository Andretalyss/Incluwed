package com.incluwed.incluwed.repository;

import com.incluwed.incluwed.classes.Places;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Places, Long> {
    Page<Places> findByNomeLocal(String nomelocal, Pageable paginacao);
}
