package fr.epsi.idee;

import java.util.List;

import fr.epsi.utilisateur.Utilisateur;

public interface IIdeeDao {
	
	void add(Utilisateur u);
	List<Utilisateur> get();

}
