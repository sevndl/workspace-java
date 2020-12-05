package fr.epsi.catalogue.io;

import fr.epsi.catalogue.SerieTV;

public class ExporteurSerie implements ExporteurArticle {

	private SerieTV serie;
	
	public ExporteurSerie(SerieTV serie) {
		this.serie = serie;
	}

	@Override
	public String exporter() {
		
		return "<article>\r\n"
				+ "  <h2>" + serie.getTitre() + "</h2>\r\n"
				+ "  <p>Une série " + serie.getDistributeur() + " en " + serie.getNombreDeSaisons() + " saisons (metascore : " + serie.getNoteMetascore() + ")</p>\r\n"
				+ "</article>";
		
	}

	
	
}
