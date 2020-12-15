package com.animoz.controller;

import javax.validation.constraints.NotBlank;

public class AnimalDto {

	@NotBlank(message="Le nom ne peut pas être nul")
	private String nom;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
