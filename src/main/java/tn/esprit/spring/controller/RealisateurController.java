package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Realisateur;
import tn.esprit.spring.services.RealisateurService;

import java.util.List;

@RestController
@RequestMapping("/realisateur")
public class RealisateurController {
    @Autowired
    private RealisateurService RealisateurServices;

    @PostMapping(value="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Realisateur> createRealisateur(@RequestBody Realisateur Realisateur){
        return new ResponseEntity<>(RealisateurServices.addRealisateur(Realisateur), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Realisateur> updateRealisateur(@PathVariable(value = "id") int id,
                                           @RequestBody Realisateur Realisateur){
        return new ResponseEntity<>(RealisateurServices.updateRealisateur( Realisateur), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Realisateur> deleteRealisateur(@PathVariable(value = "id") int id){
        RealisateurServices.deleteRealisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Realisateur> getAllRealisateurs(){
        return RealisateurServices.GetRealisateurs();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Realisateur> searchRealisateur(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(RealisateurServices.findRealisateur(id) , HttpStatus.OK);
    }
}
