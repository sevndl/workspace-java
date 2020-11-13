package FiguresGeometriques;

public abstract class Figure {
	public double getPerimetre() {
		return this.getPerimetre();
	}

	public double getAire() {
		return this.getAire();
	}

	public static void main(String[] args) {
		Figure r = new Rectangle(10, 20);
		Figure d = new Disque(5);

		System.out.println(r.getAire());
		System.out.println(r.getPerimetre());
		System.out.println(d.getAire());
		System.out.println(d.getPerimetre());
	}
}
