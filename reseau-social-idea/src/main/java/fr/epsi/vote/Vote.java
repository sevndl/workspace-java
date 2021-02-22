package fr.epsi.vote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.epsi.idee.Idee;
import fr.epsi.utilisateur.Utilisateur;

@Entity
public class Vote {
	
	public enum vote {
		top, flop
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utilisateur utilisateur;
	private vote typeVote;
	
	@ManyToOne
	private Idee idee;
	
	public Utilisateur getUtilisateur() { return this.utilisateur; }
	public Idee getIdee() { return this.idee; }
	public vote getTypeVote() { return typeVote; }
	
	public void setUtilisateur(Utilisateur u) { this.utilisateur = u; }
	public void setIdee(Idee i) { this.idee = i; }
	public void setTypeVote(vote typeVote) { this.typeVote = typeVote; }
	
}
