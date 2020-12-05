package fr.epsi.catalogue.io;

import fr.epsi.catalogue.JeuVideo;

public class ExporteurJeu implements ExporteurArticle {
	
	private JeuVideo jeu;

	public ExporteurJeu(JeuVideo jeu) {
		this.jeu = jeu;
	}

	@Override
	public String exporter() {

		return "<article>\r\n"
				+ "  <h2>" + jeu.getTitre() + "</h2>\r\n"
				+ "  <p>Un jeu vidéo de " + jeu.getStudioDeDeveloppement() + " (" + jeu.getNiveauPEGI() + " et metascore : " + jeu.getNoteMetascore() + ")</p>\r\n"
				+ "</article>";
		
	}

}
