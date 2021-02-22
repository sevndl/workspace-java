package fr.epsi.vote;

import java.util.List;

import fr.epsi.idee.Idee;
import fr.epsi.utilisateur.Utilisateur;

public interface IVoteDao {
	
	void add(Vote v);
	List<Vote> getByUtilisateur(Utilisateur u);
	List<Vote> getByIdee(Idee i);
	List<Vote> getByUtilisateurAndIdee(Utilisateur u, Idee i);

}
