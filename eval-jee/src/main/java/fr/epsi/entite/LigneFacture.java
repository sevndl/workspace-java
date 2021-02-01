package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long qte;
	private Double prix;
	
	@ManyToOne
	private Facture facture;
	
	@ManyToOne
	private Article article;
	
	public Long getQte() {
		return this.qte;
	}
	
	public void setQte(Long qte) {
		this.qte = qte;
	}

	public Double getPrix() {
		return this.prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public Facture getFacture() {
		return this.facture;
	}
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	public Article getArticle() {
		return this.article;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
}
