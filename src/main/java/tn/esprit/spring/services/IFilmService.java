package tn.esprit.spring.services;


import tn.esprit.spring.entities.Film;

import java.util.List;

public interface IFilmService {
    Film addFilm(Film Film) ;
    Film updateFilm(int id, Film newFilm);
    boolean deleteFilm(int id) ;
    List<Film> GetFilms();
    Film findFilm(int id);

    List<Film> retrieveAllFilm();
    void affecter(int idcat, int idfilm);
    }
