package fr.epsi.catalogue;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	
	List<Article> catalogue = new ArrayList<>();
	
	public void lire() {
		if (catalogue.isEmpty()) {
			System.out.println("Le catalogue est vide ! Vous pouvez lui ajouter des articles.");
		} else {
			for (Article article : catalogue) {
				System.out.println(article.getTitre());
			}			
		}
	}
	
	public void ajouterArticle(Article articleAAjouter) {
		
		try {
			int compteur = 0;
			for (Article article : catalogue) {
				if (article.getTitre().equals(articleAAjouter.getTitre())) {
					compteur += 1;
				}
			}
			if (compteur > 0) {
				throw new ArticleExistantException();
			}
			catalogue.add(articleAAjouter);
		} catch (ArticleExistantException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void supprimerArticle(Article articleASupprimer) {
		
		try {
			int compteur = 0;
			for (Article article : catalogue) {
				if (article.getTitre().equals(articleASupprimer.getTitre())) {
					compteur += 1;
				}
			}
			if (compteur == 0) {
				throw new ArticleInexistantException();
			}
			catalogue.remove(articleASupprimer);
		} catch (ArticleInexistantException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
