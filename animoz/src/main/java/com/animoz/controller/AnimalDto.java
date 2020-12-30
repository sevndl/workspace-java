package com.animoz.controller;

import javax.validation.constraints.NotBlank;

import com.animoz.modele.Regime;

public class AnimalDto {

	@NotBlank(message="Le nom ne peut pas être nul")
	private String nom;
	private String description;
	private Long especeId;
	private Regime regimeAlimentaire;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getEspece() {
		return this.especeId;
	}

	public void setEspece(Long especeId) {
		this.especeId = especeId;
	}

	public Regime getRegimeAlimentaire() {
		return this.regimeAlimentaire;
	}

	public void setRegimeAlimentaire(Regime regimeAlimentaire) {
		this.regimeAlimentaire = regimeAlimentaire;
	}
}
