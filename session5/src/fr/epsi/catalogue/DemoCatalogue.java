package fr.epsi.catalogue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import fr.epsi.catalogue.NiveauPEGI.Niveaux;
import fr.epsi.catalogue.io.ImportCatalogue;

public class DemoCatalogue {

	public static void main(String[] args) throws MalformedURLException {
		
		ImportCatalogue nouveauCatalogue = new ImportCatalogue();
		try {
			nouveauCatalogue.importer("catalogue.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
//		Catalogue catalogue = new Catalogue();
//		catalogue.lire();

//		Article MarioBros = new JeuVideo("code pour tester", "Mario Bros", -27, "studio pour tester", Niveaux.PEGI16);
//		Article Perdida = new SerieTV("code pour tester", "Perdida", 27, "distributeur pour tester", 3);
//		Article AgeDeGlace = new Film("code pour tester", "L'âge de Glace", 27, "realisateur pour tester", new URL("http://test.test"));
//		
//		System.out.println(MarioBros.getNoteMetascore());
//		MarioBros.setNoteMetascore(27);
//		System.out.println(MarioBros.getNoteMetascore());
//		
//		catalogue.ajouterArticle(MarioBros);
//		catalogue.ajouterArticle(AgeDeGlace);
//		catalogue.ajouterArticle(Perdida);
//		catalogue.ajouterArticle(Perdida);
//		catalogue.lire();
//		System.out.println();
//		System.out.println(((Film) AgeDeGlace).getAffiche());
//		
//		catalogue.supprimerArticle(AgeDeGlace);
//		catalogue.supprimerArticle(AgeDeGlace);
//		catalogue.lire();
	}

}
