package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.Parking;
import tn.esprit.spring.repositories.IParkingRepository;
import tn.esprit.spring.services.IParkingService;
import tn.esprit.spring.services.IRPService;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	
	@Autowired
	IRPService RPService;
	
	@Autowired
	IParkingRepository parkingRepo;


	@Autowired
	IParkingService parkingService;


	@Autowired
	IRPService ppService;
	
	@PostMapping("/ajouter")
	public void ajouter(@RequestBody Parking p){
		parkingRepo.save(p);
	}


	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		parkingService.supprimer(id);
	}

	@GetMapping("/get")
	public List<Parking> get(){
		return (List<Parking>) parkingService.afficher();
	}

	@PutMapping("/affect/{id-parking}/{placeparkingID}")
	public void affecterRP(@PathVariable("id-parking") Long idp ,@PathVariable("placeparkingID") Long placeparkingID ){
		ppService.affect(idp,placeparkingID);
	}
	}


