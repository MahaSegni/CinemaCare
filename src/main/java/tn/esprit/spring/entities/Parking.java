package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParking;
	private String description;
	private int capaciteParking;
	private int espaceLibre;

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	private String zone;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapaciteParking() {
		return capaciteParking;
	}

	public void setCapaciteParking(int capaciteParking) {
		this.capaciteParking = capaciteParking;
	}

	public int getEspaceLibre() {
		return espaceLibre;
	}

	public void setEspaceLibre(int espaceLibre) {
		this.espaceLibre = espaceLibre;
	}


	@JsonIgnore
	@OneToMany(mappedBy="placeparking", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<PlaceParking> placeparkings;

	public List<PlaceParking> getPlaceparkings() {
		return placeparkings;
	}

	public void setPlaceparkings(List<PlaceParking> placeparkings) {
		this.placeparkings = placeparkings;
	}

	public Parking() {
		super();
		// TODO Auto-generated constructor stub
	}


}
