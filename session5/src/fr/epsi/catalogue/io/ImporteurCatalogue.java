package fr.epsi.catalogue.io;

import java.io.IOException;
import fr.epsi.catalogue.Catalogue;

public interface ImporteurCatalogue {

	Catalogue importer() throws IOException, NullPointerException;

}
