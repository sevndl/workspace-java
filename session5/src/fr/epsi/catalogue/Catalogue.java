package fr.epsi.catalogue;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	
	List<Article> articles = new ArrayList<>();
	
	public List<Article> getArticles() {
		return this.articles;
	}
	
	public void lire() {
		if (articles.isEmpty()) {
			System.out.println("Le catalogue est vide ! Vous pouvez lui ajouter des articles.");
		} else {
			for (Article article : articles) {
				System.out.println("  " + article.getTitre() + ", " + article.getNoteMetascore());
			}			
		}
	}
	
	public void ajouterArticle(Article articleAAjouter) {
		
		try {
			int compteur = 0;
			for (Article article : articles) {
				if (article.getTitre().equals(articleAAjouter.getTitre())) {
					compteur += 1;
				}
			}
			if (compteur > 0) {
				throw new ArticleExistantException();
			}
			articles.add(articleAAjouter);
		} catch (ArticleExistantException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void supprimerArticle(Article articleASupprimer) {
		
		try {
			int compteur = 0;
			for (Article article : articles) {
				if (article.getTitre().equals(articleASupprimer.getTitre())) {
					compteur += 1;
				}
			}
			if (compteur == 0) {
				throw new ArticleInexistantException();
			}
			articles.remove(articleASupprimer);
		} catch (ArticleInexistantException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
