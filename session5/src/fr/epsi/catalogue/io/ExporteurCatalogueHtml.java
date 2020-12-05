package fr.epsi.catalogue.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.epsi.catalogue.Article;
import fr.epsi.catalogue.Catalogue;

public class ExporteurCatalogueHtml implements ExporteurCatalogue {
	
	private String pathDestination;
	
	public ExporteurCatalogueHtml(String pathDestination) {
		this.pathDestination = pathDestination + "catalogue.html";
	}

	@Override
	public void exporter(Catalogue catalogue) throws IOException {

		String catalogueHtml = "<html lang=\"fr\">\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"utf-8\">\r\n"
				+ "  <title>Catalogue</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<h1>Catalogue</h1>\r\n"
				+ "";
		
		for (Article article : catalogue.getArticles()) {
			String articleHtml = ExporteurArticleFabrique.getExporteur(article).exporter();
			catalogueHtml += articleHtml;
			catalogueHtml += "\r\n";
		}
		
		catalogueHtml += "</body>\r\n"
					   + "</html>";
		
		// écrire dans un fichier
		File file = new File(pathDestination);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(catalogueHtml);
		bw.close();
		
	}

}
