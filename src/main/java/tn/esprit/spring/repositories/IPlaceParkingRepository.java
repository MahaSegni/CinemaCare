package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.PlaceParking;


@Repository
public interface IPlaceParkingRepository extends CrudRepository<PlaceParking, Long>{
	
	
}
