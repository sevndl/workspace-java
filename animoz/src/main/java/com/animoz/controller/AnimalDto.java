package com.animoz.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.animoz.modele.Regime;

public class AnimalDto {

	@NotBlank(message = "Requis")
	private String nom;
	private String description;
	@NotNull(message = "Requis")
	private Regime regimeAlimentaire;
	@NotNull(message = "Requis")
	private Long espece;

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
		return this.espece;
	}

	public void setEspece(Long especeId) {
		this.espece = especeId;
	}

	public Regime getRegimeAlimentaire() {
		return this.regimeAlimentaire;
	}

	public void setRegimeAlimentaire(Regime regimeAlimentaire) {
		this.regimeAlimentaire = regimeAlimentaire;
	}
}
