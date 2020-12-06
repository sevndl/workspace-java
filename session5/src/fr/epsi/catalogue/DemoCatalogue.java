package fr.epsi.catalogue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import fr.epsi.catalogue.NiveauPEGI.Niveaux;
import fr.epsi.catalogue.io.ExporteurCatalogueHtml;
import fr.epsi.catalogue.io.ImplImporteurCatalogue;
import fr.epsi.catalogue.io.ImplImporteurCatalogue;

public class DemoCatalogue {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Entrez un chemin de fichier pour en créer un catalogue : ");
		String nomFichier = scanner.next();
		System.out.println("Entrez le chemin où sera stocké le fichier html : ");
		String pathDestination = scanner.next();
		// C:/Users/nandi/Desktop/Code/EPSI/B3/workspace-java/session5/src/fr/epsi/catalogue/catalogue.txt
		// C:/Users/nandi/Desktop/
		
		try {
			ImplImporteurCatalogue nouveauCatalogue = new ImplImporteurCatalogue(nomFichier);
			Catalogue catalogue = nouveauCatalogue.importer();
			
			if (catalogue == null) {
				main(args);
			} else {
				ExporteurCatalogueHtml exporteurHtml = new ExporteurCatalogueHtml(pathDestination);
				exporteurHtml.exporter(catalogue);								
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			main(args);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			main(args);
		}
		
	}

}
