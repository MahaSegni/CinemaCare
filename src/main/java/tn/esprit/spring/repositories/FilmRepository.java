package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Film;

public interface FilmRepository extends CrudRepository<Film,Integer> {


}
