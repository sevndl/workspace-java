package FiguresGeometriques;

@SuppressWarnings("serial")
public class FigureInterditeException extends Exception {

	public FigureInterditeException(String message) {
		super("Erreur : " + message);
	}

}
