package com.animoz.modele;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String origine;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Regime regime;
	
	@ManyToOne
	@JoinColumn(name = "espece_id")
	private Espece espece;
	
	@ManyToMany
	@JoinTable(name = "populationsoigneur",
			   joinColumns = @JoinColumn(name = "animal_id"),
			   inverseJoinColumns = @JoinColumn(name = "soigneur_id"))
	private Set<Soigneur> soigneurs = new HashSet<Soigneur>();

	public Long getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getOrigine() {
		return this.origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Regime getRegime() {
		return this.regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}
	
	public Espece getEspece() {
		return this.espece;
	}
	
	public void setEspece(Espece espece) {
		this.espece = espece;
	}

}
