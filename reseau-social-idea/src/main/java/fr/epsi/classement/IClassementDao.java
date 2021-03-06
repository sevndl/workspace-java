package fr.epsi.classement;

import java.util.List;

import fr.epsi.idee.Idee;
import fr.epsi.utilisateur.Utilisateur;

public interface IClassementDao {
	
	List<Idee> getTop3IdeesPlusDeVotes();
	List<Utilisateur> getTop3UtilisateursPlusIdees();
	List<Idee> getTop3IdeesMieuxNotees();

}
