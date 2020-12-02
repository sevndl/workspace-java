package fr.epsi.catalogue;

@SuppressWarnings("serial")
public class ArticleInexistantException extends Exception {

	public ArticleInexistantException() {
		
		super("Erreur : l'article que vous essayez de supprimer du catalogue n'existe pas.");
		
	}

}
