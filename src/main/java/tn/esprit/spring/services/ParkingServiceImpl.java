package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Parking;
import tn.esprit.spring.repositories.IParkingRepository;

@Service
@Slf4j
public class ParkingServiceImpl implements IParkingService {

	@Autowired
	IParkingRepository PR;



	@Override
	public Parking ajouter(Parking parking) {

		return PR.save(parking);
	}

	@Override
	public Parking update(Parking parking, Long id) {
		if(PR.findById(id).isPresent()){
			Parking cl = PR.findById(id).get();
			cl.setDescription(parking.getDescription());
			cl.setCapaciteParking(parking.getCapaciteParking());
			cl.setZone(parking.getZone());


			return PR.save(cl);
		}
		return null;
	}

	@Override
	public void supprimer(Long id) {
		PR.deleteById(id);
	}


	@Override
	public Iterable<Parking> afficher() {

		return PR.findAll();
	}

	@Override
	public Optional<Parking> findById(Long id) {

		return PR.findById(id);
	}
}
