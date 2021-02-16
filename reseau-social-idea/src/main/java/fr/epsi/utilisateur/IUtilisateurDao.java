package fr.epsi.utilisateur;

import java.util.List;

public interface IUtilisateurDao {
	
	void add(Utilisateur u);
	List<Utilisateur> get(String mail, String password);
	List<Utilisateur> checkMail(String mail);
	List<Utilisateur> checkUsername(String username);

}
