package FiguresGeometriques;

public class Rectangle extends Figure {
	private double longueur;
	private double largeur;

	public Rectangle(double longueur, double largeur) {
		if (longueur < 0 || largeur < 0) {
			throw new IllegalArgumentException("Un côté ne peut pas être nul");
		}
		this.longueur = longueur;
		this.largeur = largeur;			
	}

	public Rectangle(double cote) {
		if (cote < 0) {
			throw new IllegalArgumentException("Un côté ne peut pas être nul");
		}
		this.longueur = cote;
		this.largeur = cote;
	}

	public Rectangle(Rectangle r) {
		this(r.longueur, r.largeur);
	}

	public double getLongueur() {
		return this.longueur;
	}

	public void setLongueur(double valeur) {
		if (valeur < 0) {
			throw new IllegalArgumentException("Un côté ne peut pas être nul");
		}
		this.longueur = valeur;
	}

	public double getLargeur() {
		return this.largeur;
	}

	public void setLargeur(double valeur) {
		if (valeur < 0) {
			throw new IllegalArgumentException("Un côté ne peut pas être nul");
		}
		this.largeur = valeur;
	}

	public double getPerimetre() {
	    return 2 * (this.largeur + this.longueur);
	}

	public double getAire() {
	  return this.largeur * this.longueur;
	}

	public boolean isCarre() {
		return this.largeur == this.longueur;
	}

	public void transpose() {
		double temp;

		temp = this.longueur;
		this.longueur = this.largeur;
		this.largeur = temp;
	}

}
