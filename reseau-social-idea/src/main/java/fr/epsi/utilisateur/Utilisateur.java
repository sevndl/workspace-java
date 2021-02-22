package fr.epsi.utilisateur;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.epsi.idee.Idee;
import fr.epsi.vote.Vote;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private Date dateCreation;
	private String mail;
	private String password;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Idee> idees;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Vote> votes;
	
	public Long getId() { return this.id; }
	public String getUsername() { return this.username; }
	public Date getDateCreation() { return this.dateCreation; }
	public String getMail() { return this.mail; }
	public String getPassword() { return this.password; }
	public List<Idee> getIdees() { return this.idees; }
	public List<Vote> getVotes() { return this.votes; }
		
	public void setUsername(String username) { this.username = username; }
	public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
	public void setMail(String mail) { this.mail = mail; }
	public void setPassword(String password) { this.password = password; }
	public void setIdees(List<Idee> idees) { this.idees = idees; }
	public void setVotes(List<Vote> votes) { this.votes = votes; }
	
}