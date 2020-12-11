package com.animoz.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Population {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private Long nombreIndividus;
	
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animalId;
	
	public Animal getAnimal() {
		return this.animalId;
	}
	
	public void setAnimal(Animal animalId) {
		this.animalId = animalId;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Long getNombreIndividus() {
		return this.nombreIndividus;
	}
	
	public void setNombreIndividus(Long nombreIndividus) {
		this.nombreIndividus = nombreIndividus;
	}
	
}
