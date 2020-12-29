package com.animoz.controller;

import javax.validation.constraints.NotBlank;

import com.animoz.modele.Espece;

public class AnimalDto {

	@NotBlank(message="Le nom ne peut pas être nul")
	private String nom;
	private String description;
	private Long especeId;

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
}
