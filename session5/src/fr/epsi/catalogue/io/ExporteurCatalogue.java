package fr.epsi.catalogue.io;

import java.io.IOException;

import fr.epsi.catalogue.Catalogue;

public interface ExporteurCatalogue {

	void exporter(Catalogue catalogue) throws IOException;

}