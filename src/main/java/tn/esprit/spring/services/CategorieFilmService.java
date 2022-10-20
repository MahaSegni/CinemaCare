package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.CategorieFilm;
import tn.esprit.spring.entities.Film;
import tn.esprit.spring.entities.Parking;
import tn.esprit.spring.entities.PlaceParking;
import tn.esprit.spring.repositories.CategorieFilmRepository;
import tn.esprit.spring.repositories.FilmRepository;

import java.util.List;
@Service
@Slf4j
public class CategorieFilmService implements ICategorieFilmService{

    @Autowired
    CategorieFilmRepository categorieFilmRepository;
    @Autowired
    FilmRepository filmRepository;
    @Override
    public CategorieFilm addCategorieFilm(CategorieFilm categorieFilm) {
        categorieFilmRepository.save(categorieFilm);
        return categorieFilm;
    }

    @Override
    public CategorieFilm updateCategorieFilm(CategorieFilm newCategorieFilm) {
        categorieFilmRepository.save(newCategorieFilm);
        return newCategorieFilm;
    }

    @Override
    public boolean deleteCategorieFilm(int id) {
        if(categorieFilmRepository.findById(id).isPresent()) {
            categorieFilmRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }



    @Override
    public CategorieFilm findCategorieFilm(int id) {
        CategorieFilm categoriefilm = categorieFilmRepository.findById(id).orElse(null);
        return categoriefilm;
    }
    @Override
    public List<CategorieFilm> retrieveAllCategorieFilm() {
        return (List<CategorieFilm>) categorieFilmRepository.findAll();
    }


}
