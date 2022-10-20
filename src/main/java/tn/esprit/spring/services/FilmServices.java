package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.CategorieFilm;
import tn.esprit.spring.entities.Film;
import tn.esprit.spring.repositories.FilmRepository;

import java.util.List;

@Service
@Slf4j
public class FilmServices implements IFilmService{
    @Autowired
    private tn.esprit.spring.repositories.FilmRepository FilmRepository;
    @Autowired
    private tn.esprit.spring.repositories.CategorieFilmRepository categorieFilmRepository;
    public Film addFilm(Film Film) {
        return FilmRepository.save(Film);
    }

    public Film updateFilm(int id, Film newFilm) {
        if(FilmRepository.findById(id).isPresent()) {
            Film existingFilm = FilmRepository.findById(id).get();
            existingFilm.setNomFilm(newFilm.getNomFilm());
            existingFilm.setDescription(newFilm.getDescription());
            existingFilm.setDateSortie(newFilm.getDateSortie());
            existingFilm.setRealisateurs(newFilm.getRealisateurs());
            existingFilm.setActeurs(newFilm.getActeurs());
            existingFilm.setDuree(newFilm.getDuree());

            return FilmRepository.save(existingFilm);
        }
        else {
            return null;
        }
    }

    public boolean deleteFilm(int id) {
        if(FilmRepository.findById(id).isPresent()) {
            FilmRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }



    public List<Film> GetFilms() {
        return (List<Film>) FilmRepository.findAll();
    }

    public Film findFilm(int id) {
        if(FilmRepository.findById(id).isPresent()) {
            Film existingFilm = FilmRepository.findById(id).get();
            return existingFilm;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Film> retrieveAllFilm() {
        return (List<Film>) FilmRepository.findAll();

    }
    @Override
    public void affecter(int idcat, int idfilm) {
        Film film = FilmRepository.findById(idfilm).orElse(null);
        CategorieFilm categorieFilm = categorieFilmRepository.findById(idcat).orElse(null);
        film.setCategorieFilm(categorieFilm);
        FilmRepository.save(film);
    }
}
