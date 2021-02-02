package fr.epsi.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Champ obligatoire")
	private String nom;
	@NotNull(message = "Champ obligatoire")
	private String adresse;
	
	@OneToMany(mappedBy = "client")
	private List<Facture> factures;
	
	public Long getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public List<Facture> getFactures() {
		return this.factures;
	}
	
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

}
