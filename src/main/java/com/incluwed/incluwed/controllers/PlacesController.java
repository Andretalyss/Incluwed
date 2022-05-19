package com.incluwed.incluwed.controllers;

import com.incluwed.incluwed.classes.Places;
import com.incluwed.incluwed.dto.PlacesDto;
import com.incluwed.incluwed.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ranking")
public class PlacesController {

    @Autowired
    private PlacesRepository placesRepository;

    @GetMapping
    public Page<PlacesDto> listarPostagensRanking(@RequestParam int pag){
        Pageable paginacao  = PageRequest.of(pag, 5, Sort.by("numbersPosts").descending().and(Sort.by("nota").descending()));
        Page<Places> places = placesRepository.findAll(paginacao);

        return PlacesDto.convert(places);
    }

}
