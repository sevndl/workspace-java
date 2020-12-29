package com.animoz.controller;

import javax.validation.constraints.NotBlank;

public class AnimalDto {

	@NotBlank(message="Le nom ne peut pas être nul")
	private String nom;
	private String description;

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
}
