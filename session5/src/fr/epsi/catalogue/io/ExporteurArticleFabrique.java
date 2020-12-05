package fr.epsi.catalogue.io;

import fr.epsi.catalogue.Article;
import fr.epsi.catalogue.Film;
import fr.epsi.catalogue.JeuVideo;
import fr.epsi.catalogue.SerieTV;

public class ExporteurArticleFabrique {

	public static ExporteurArticle getExporteur(Article article) {
		
		if (article instanceof Film) {
			return new ExporteurFilm((Film) article);
		} else if (article instanceof SerieTV) {
			return new ExporteurSerie((SerieTV) article);
		} else if (article instanceof JeuVideo) {
			return new ExporteurJeu((JeuVideo) article);
		} else {
			throw new IllegalArgumentException("Type d'article non reconnu");
		}
		
	}

}
