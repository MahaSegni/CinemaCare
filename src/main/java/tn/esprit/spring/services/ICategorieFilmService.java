package tn.esprit.spring.services;


import tn.esprit.spring.entities.CategorieFilm;

import java.util.List;

public interface ICategorieFilmService {
    CategorieFilm addCategorieFilm(CategorieFilm categorieFilm) ;
    CategorieFilm updateCategorieFilm( CategorieFilm newCategorieFilm);
    boolean deleteCategorieFilm(int id) ;
    CategorieFilm findCategorieFilm(int id);
    List<CategorieFilm> retrieveAllCategorieFilm();

}
