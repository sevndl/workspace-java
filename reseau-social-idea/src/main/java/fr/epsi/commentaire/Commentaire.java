package fr.epsi.commentaire;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.epsi.idee.Idee;
import fr.epsi.utilisateur.Utilisateur;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenu;
	private Date dateCreation;

	@ManyToOne
	private Utilisateur auteur;
	
	@ManyToOne
	private Idee idee;
	
	public Utilisateur getAuteur() {
		return this.auteur;
	}
	
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	
	public String getContenu() {
		return this.contenu;
	}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Idee getIdee() {
		return this.idee;
	}
	
	public void setIdee(Idee idee) {
		this.idee = idee;
	}
	
}
