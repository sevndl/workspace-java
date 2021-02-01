package fr.epsi.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Double prix;
	
	@OneToMany(mappedBy = "article")
	private List<LigneFacture> lignesFacture;
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Double getPrix() {
		return this.prix;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public List<LigneFacture> getLignesFacture() {
		return this.lignesFacture;
	}
	
	public void setLignesFacture(List<LigneFacture> lignesFacture) {
		this.lignesFacture = lignesFacture;
	}
	
}
