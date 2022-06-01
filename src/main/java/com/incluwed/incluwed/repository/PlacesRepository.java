package com.incluwed.incluwed.repository;

import com.incluwed.incluwed.classes.Places;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlacesRepository extends JpaRepository<Places, Long> {
    Optional<Places> findByNomeLocal(String nomelocal);
}
