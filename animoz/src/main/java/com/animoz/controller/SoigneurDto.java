package com.animoz.controller;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class SoigneurDto {

	@NotBlank(message = "Requis")
	private String nom;
	@NotBlank(message = "Requis")
	private String numero;
	@NotBlank(message = "Requis")
	private String dateRecrutement;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDateRecrutement() {
		return this.dateRecrutement;
	}

	public void setDateRecrutement(String dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

}
