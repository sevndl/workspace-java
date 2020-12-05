package fr.epsi.catalogue.io;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import fr.epsi.catalogue.Catalogue;
import fr.epsi.catalogue.JeuVideo;
import fr.epsi.catalogue.Film;
import fr.epsi.catalogue.SerieTV;
import fr.epsi.catalogue.NiveauPEGI.Niveaux;

public class ImportCatalogue implements ImporteurCatalogue {

	@Override
	public Catalogue importer(String nomFichier) throws IOException, NullPointerException {
		
		try {
			
			Path fichier = Paths.get(nomFichier);
			if (!Files.exists(fichier)) {
				throw new NullPointerException("Le fichier n'existe pas.");
			}
			List<String> contenu = Files.readAllLines(fichier);
			Catalogue catalogue = new Catalogue();
			
			for (String ligne : contenu) {
				String[] contenuLigne = ligne.split(";");
				int noteMetascore = Integer.parseInt(contenuLigne[2]);
				switch (contenuLigne[3]) {
				case "jeu":
					JeuVideo jeuVideo = new JeuVideo(contenuLigne[0], contenuLigne[1], noteMetascore, contenuLigne[4], Niveaux.valueOf(contenuLigne[5]));
					catalogue.ajouterArticle(jeuVideo);
					break;
				case "serie":
					SerieTV serieTV = new SerieTV(contenuLigne[0], contenuLigne[1], noteMetascore, contenuLigne[4], Integer.parseInt(contenuLigne[5]));
					catalogue.ajouterArticle(serieTV);
					break;
				case "film":
					Film film = new Film(contenuLigne[0], contenuLigne[1], noteMetascore, contenuLigne[4], new URL(contenuLigne[5]));
					catalogue.ajouterArticle(film);
					break;
				default:
					throw new IOException("Le type de contenu n'est pas reconnu.");
				}
			}
			return catalogue;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
