package fr.epsi.utilisateur;

import java.util.List;

public interface IUtilisateurService {
	
	void add(Utilisateur u);
	Utilisateur get(String mail, String password);
	List<Utilisateur> checkMail(String mail);
	List<Utilisateur> checkUsername(String username);

}
