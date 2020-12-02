package fr.epsi.catalogue;

import java.net.URL;

public class Film extends Article {
	
	private String realisateur; 
	private URL affiche;

	public Film(String realisateur, URL affiche, String code, String titre, int noteMetascore) {

		super.setCode(code);
		super.setTitre(titre);
		super.setNoteMetascore(noteMetascore);
		this.setAffiche(affiche);
		this.setRealisateur(realisateur);
		
	}

	protected URL getAffiche() {
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
