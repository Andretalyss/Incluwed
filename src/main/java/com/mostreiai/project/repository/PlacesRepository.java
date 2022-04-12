package com.mostreiai.project.repository;

import com.mostreiai.project.classes.Places;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Places,Long> {
    Page<Places> findByNomeLocal(String nomeLocal, Pageable paginacao);
}
