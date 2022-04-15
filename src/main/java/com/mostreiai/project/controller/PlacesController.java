package com.mostreiai.project.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.mostreiai.project.classes.Places;
import com.mostreiai.project.classes.PlacesDto;
import com.mostreiai.project.forms.AttPlacesForm;
import com.mostreiai.project.forms.PlacesForm;
import com.mostreiai.project.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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

    @GetMapping("/{id}")
    public ResponseEntity<PlacesDto> detalharPlaces(@PathVariable Long id) {

        Optional<Places> places = placesRepository.findById(id);
        if ( places.isPresent()){
            return ResponseEntity.ok(new PlacesDto(places.get()));
        } 

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PlacesDto> CadastrarPlaces(@RequestBody @Valid PlacesForm form, UriComponentsBuilder uriBuilder) {
        
        Places places = form.converter();
        placesRepository.save(places);
        URI uri = uriBuilder.path("/ranking/{id}").buildAndExpand(places.getId()).toUri();
        return ResponseEntity.created(uri).body(new PlacesDto(places));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PlacesDto> atualizarPlace(@PathVariable Long id, @RequestBody @Valid AttPlacesForm form) {
        Optional<Places> optional = placesRepository.findById(id);
        if (optional.isPresent()){

            Places places = form.atualizar(id, placesRepository);

            return ResponseEntity.ok(new PlacesDto(places));
        }

        return ResponseEntity.notFound().build();        
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerPlace(@PathVariable Long id){
        Optional<Places> optional = placesRepository.findById(id);
        if (optional.isPresent()){
            placesRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
        
    }

}