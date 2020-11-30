package FiguresGeometriques;

public class Disque extends Figure {
	private double rayon;

	public Disque(double rayon) {
		setRayon(rayon);
	}

	public Disque(Disque d) {
		this(d.rayon);
	}

	public double getRayon() {
		return this.rayon;
	}

	public void setRayon(double rayon) {
		if (rayon < 0) {
			throw new IllegalArgumentException("Le rayon ne peut pas être négatif");
		}
		this.rayon = rayon;
	}

	public double getPerimetre() {
		return 2 * Math.PI * this.rayon;
	}

	public double getAire() {
		return Math.PI * this.rayon * this.rayon;
	}
}
