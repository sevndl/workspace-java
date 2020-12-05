package fr.epsi.catalogue;

import java.net.URL;

public class Film extends Article {
	
	private String realisateur; 
	private URL affiche;

	public Film(String code, String titre, int noteMetascore, String realisateur, URL affiche) {

		super.setCode(code);
		super.setTitre(titre);
		super.setNoteMetascore(noteMetascore);
		this.setAffiche(affiche);
		this.setRealisateur(realisateur);
		
	}

	public URL getAffiche() {
		return this.affiche;
	}

	public void setAffiche(URL affiche) {
		this.affiche = affiche;
	}

	public String getRealisateur() {
		return this.realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

}
