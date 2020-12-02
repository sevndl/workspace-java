package fr.epsi.catalogue;

@SuppressWarnings("serial")
public class ArticleExistantException extends Exception {

	public ArticleExistantException() {
		
		super("Erreur : l'article que vous essayez d'ajouter au catalogue existe déjà.");
		
	}

}
