package fr.epsi.catalogue;

import java.net.MalformedURLException;
import java.net.URL;

import fr.epsi.catalogue.NiveauPEGI.Niveaux;

public class DemoCatalogue {

	public static void main(String[] args) throws MalformedURLException {
		
		Catalogue catalogue = new Catalogue();
		catalogue.lire();

		Article MarioBros = new JeuVideo(Niveaux.PEGI16, "studio pour tester", "code pour tester", "Mario Bros", -27);
		Article Perdida = new SerieTV("distributeur pour tester", 3, "code pour tester", "Perdida", 27);
		Article AgeDeGlace = new Film("realisateur pour tester", new URL("http://test.test"), "code pour tester", "L'âge de Glace", 27);
		
		System.out.println(MarioBros.getNoteMetascore());
		MarioBros.setNoteMetascore(27);
		System.out.println(MarioBros.getNoteMetascore());
		
		catalogue.ajouterArticle(MarioBros);
		catalogue.ajouterArticle(AgeDeGlace);
		catalogue.ajouterArticle(Perdida);
		catalogue.ajouterArticle(Perdida);
		catalogue.lire();
		System.out.println();
		System.out.println(((Film) AgeDeGlace).getAffiche());
		
		catalogue.supprimerArticle(AgeDeGlace);
		catalogue.supprimerArticle(AgeDeGlace);
		catalogue.lire();
	}

}
