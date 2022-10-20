package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlaceParking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRP;

	private Long numero ;
	private String etat ;
	@ManyToOne
	private PlaceParking placeparking;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public PlaceParking getPlaceparking() {
		return placeparking;
	}

	public void setPlaceparking(PlaceParking placeparking) {
		this.placeparking = placeparking;
	}

	public PlaceParking() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
