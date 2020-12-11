package com.animoz.modele;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private Espece especeId;
	
	@OneToMany(mappedBy = "animalId")
	private List<Population> populations;

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
		return this.especeId;
	}
	
	public void setEspece(Espece espece) {
		this.especeId = espece;
	}

}
