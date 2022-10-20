package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Parking;
import tn.esprit.spring.entities.PlaceParking;
import tn.esprit.spring.repositories.IParkingRepository;
import tn.esprit.spring.repositories.IPlaceParkingRepository;

@Service
public class RPServiceImpl implements IRPService {
	
	@Autowired
	IPlaceParkingRepository ppRepo;
	
	@Autowired
	IParkingRepository parkingRepository;


	@Override
	public void affect(Long parkingID, Long placeparking) {
		Parking parking = parkingRepository.findById(parkingID).orElse(null);
		PlaceParking pp = ppRepo.findById(placeparking).orElse(null);
		parking.getPlaceparkings().add(pp);
		parkingRepository.save(parking);

	}
}
