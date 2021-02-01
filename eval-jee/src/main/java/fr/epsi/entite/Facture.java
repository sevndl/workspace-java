package fr.epsi.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String numero;
	private Double prix;
	
	@ManyToOne
	private Client client;
	
	@OneToMany(mappedBy = "facture")
	private List<LigneFacture> lignesfacture;
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String nom) {
		this.numero = nom;
	}
	
	public Double getPrix() {
		return this.prix;
	}
	
	public void setprix(Double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<LigneFacture> getLignesFacture() {
		return this.lignesfacture;
	}
	
	public void setLignesFacture(List<LigneFacture> lignesFacture) {
		this.lignesfacture = lignesFacture;
	}

}
