package dev.gayerie.tuto.pizza.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import dev.gayerie.tuto.pizza.model.Pizza;

public class CommandeInfo {

	@NotBlank(message = "{validation.commandeInfo.nom}")
	private String nom;
	@Pattern(regexp = "\\+?[0-9. ]{10,}", message = "{validation.commandeInfo.telephone}")
	private String telephone;
	@NotNull(message = "{validation.commandeInfo.pizza.id}")
	private Pizza pizza;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
