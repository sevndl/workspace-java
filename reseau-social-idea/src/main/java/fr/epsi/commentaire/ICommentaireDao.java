package fr.epsi.commentaire;

import java.util.List;

import fr.epsi.idee.Idee;

public interface ICommentaireDao {
	
	void add(Commentaire c);
	List<Commentaire> get();
	List<Commentaire> getByIdee(Idee idee);

}
