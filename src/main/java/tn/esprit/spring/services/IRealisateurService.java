package tn.esprit.spring.services;


import tn.esprit.spring.entities.Realisateur;

import java.util.List;

public interface IRealisateurService {

    Realisateur addRealisateur(Realisateur realisateur) ;
    Realisateur updateRealisateur( Realisateur newRealisateur);
    boolean deleteRealisateur(int id) ;
    List<Realisateur> GetRealisateurs();
    Realisateur findRealisateur(int id);

    List<Realisateur> retrieveAllRealisateur();

}
