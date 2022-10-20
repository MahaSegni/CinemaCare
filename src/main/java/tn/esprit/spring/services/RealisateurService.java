package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Realisateur;
import tn.esprit.spring.repositories.RealisateurRepository;

import java.util.List;
@Service
@Slf4j
public class RealisateurService implements IRealisateurService{

    @Autowired
    RealisateurRepository realisateurRepository;

    @Override
    public Realisateur addRealisateur(Realisateur realisateur) {
        realisateurRepository.save(realisateur);
        return realisateur;
    }

    @Override
    public Realisateur updateRealisateur( Realisateur newRealisateur) {
        realisateurRepository.save(newRealisateur);
        return newRealisateur;
    }

    @Override
    public boolean deleteRealisateur(int id) {
        if(realisateurRepository.findById(id).isPresent()) {
            realisateurRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Realisateur> GetRealisateurs() {
        return (List<Realisateur>) realisateurRepository.findAll();
    }

    @Override
    public Realisateur findRealisateur(int id) {
        Realisateur realisateur = realisateurRepository.findById(id).orElse(null);
        return realisateur;
    }

    @Override
    public List<Realisateur> retrieveAllRealisateur() {
        return (List<Realisateur>) realisateurRepository.findAll();
    }
}
