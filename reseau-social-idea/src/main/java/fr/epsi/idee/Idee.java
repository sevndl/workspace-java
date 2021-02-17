package fr.epsi.idee;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.epsi.categorie.Categorie;
import fr.epsi.commentaire.Commentaire;
import fr.epsi.utilisateur.Utilisateur;
import fr.epsi.vote.Vote;

@Entity
public class Idee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private String image;
	private Date date;
	@Enumerated
	@ElementCollection(targetClass = Vote.class)
	private List<Vote> vote;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Categorie categorie;
	
	@OneToMany(mappedBy = "idee")
	private List<Commentaire> commentaires;

	public Long getId() {
		return this.id;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public List<Vote> getVote() {
		return this.vote;
	}
	
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	
	public Categorie getCategorie() {
		return this.categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
