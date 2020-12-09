package dev.gayerie.tuto.pizza.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nom;
	@Enumerated(STRING)
	@Column(nullable = false)
	private BasePizza base;
	@ManyToMany
	@JoinTable(
		name = "pizza_ingredient", 
		joinColumns = @JoinColumn(name = "pizza_id", nullable = false), 
		inverseJoinColumns = @JoinColumn(name = "ingredient_id", nullable = false), 
		uniqueConstraints = @UniqueConstraint(columnNames = {"pizza_id", "ingredient_id"})
	)
	private List<Ingredient> ingredients = new ArrayList<>();

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
	
	public BasePizza getBase() {
		return base;
	}
	
	public void setBase(BasePizza base) {
		this.base = base;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
