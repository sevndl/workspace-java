package com.animoz.modele;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Soigneur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String nom;
	
	@Temporal(TemporalType.DATE)
	@Column(updatable=false)
	private Date dateRecrutement;
	
	@ManyToMany
	@JoinTable(name = "populationsoigneur",
			   joinColumns = @JoinColumn(name = "soigneur_id"),
			   inverseJoinColumns = @JoinColumn(name = "animal_id"))
	private Set<Animal> animaux = new HashSet<Animal>();
	
	public Long getId() {
		return this.id;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateRecrutement() {
		return this.dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
}
