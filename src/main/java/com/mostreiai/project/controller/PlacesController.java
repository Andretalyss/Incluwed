package com.mostreiai.project.controller;

import java.util.Optional;
import javax.transaction.Transactional;
import com.mostreiai.project.classes.Places;
import com.mostreiai.project.classes.PlacesDto;
import com.mostreiai.project.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ranking")
public class PlacesController {

    @Autowired
    private PlacesRepository placesRepository;

    @GetMapping
    public Page<PlacesDto> ListaPostagensRank(@RequestParam int pagina, @RequestParam int qtd) {
        Pageable paginacao = PageRequest.of(pagina, qtd);
        Page<Places> lugares = placesRepository.findAll(paginacao);
        return PlacesDto.convert(lugares);
    }
}