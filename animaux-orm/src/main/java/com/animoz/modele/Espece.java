package com.animoz.modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Espece {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // pour préciser à hibernate que c'est en auto-increment
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy = "especeId")
	private List<Animal> animaux;
	
	public List<Animal> getAnimaux() {
		return this.animaux;
	}
	
	public void setAnimaux(List<Animal> animaux) {
		this.animaux = animaux;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
