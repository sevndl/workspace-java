package fr.epsi.catalogue.io;

import fr.epsi.catalogue.Film;

public class ExporteurFilm implements ExporteurArticle {
	
	private Film film;
	
	public ExporteurFilm(Film film) {
		this.film = film;
	}

	@Override
	public String exporter() {
		
		return "<article>\r\n"
				+ "  <h2>" + film.getTitre() + "</h2>\r\n"
				+ "  <p>Un film de " + film.getRealisateur() + " (metascore : " + film.getNoteMetascore() + ")</p>\r\n"
				+ "  <img src=\"" + film.getAffiche() + "\" alt=\"affiche\">\r\n"
				+ "</article>";
		
	}

}
