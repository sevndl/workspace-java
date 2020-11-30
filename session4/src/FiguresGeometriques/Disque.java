package FiguresGeometriques;

public class Disque extends Figure {
	private double rayon;

	public Disque(double rayon) {
		this.rayon = rayon;
	}

	public Disque(Disque d) {
		this(d.rayon);
	}

	public double getRayon() {
		return this.rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public double getPerimetre() {
		return 2 * Math.PI * this.rayon;
	}

	public double getAire() {
		return Math.PI * this.rayon * this.rayon;
	}
}
