package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.CategorieFilm;
import tn.esprit.spring.services.CategorieFilmService;

import java.util.List;

@RestController
@RequestMapping("/Categoriefilm")
public class CategorieController {
    @Autowired
    private CategorieFilmService CategorieFilmServices;

    @PostMapping(value="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategorieFilm> createCategorieFilm(@RequestBody CategorieFilm Categoriefilm){
        return new ResponseEntity<>(CategorieFilmServices.addCategorieFilm(Categoriefilm), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategorieFilm> updateCategorieFilm(@PathVariable(value = "id") int id,
                                           @RequestBody CategorieFilm Categoriefilm){
        return new ResponseEntity<>(CategorieFilmServices.updateCategorieFilm( Categoriefilm), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategorieFilm> deleteCategorieFilm(@PathVariable(value = "id") int id){
        CategorieFilmServices.deleteCategorieFilm(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<CategorieFilm> getAllCategorieFilms(){
        return CategorieFilmServices.retrieveAllCategorieFilm();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategorieFilm> searchCategorieFilm(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(CategorieFilmServices.findCategorieFilm(id) , HttpStatus.OK);
    }
  
}
