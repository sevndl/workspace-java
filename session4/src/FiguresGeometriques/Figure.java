package FiguresGeometriques;

public abstract class Figure {
	public double getPerimetre() {
		return this.getPerimetre();
	}

	public double getAire() {
		return this.getAire();
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Figure) {
			Figure f = (Figure) object;
			return (this.getAire() == f.getAire() && this.getPerimetre() == f.getPerimetre());
		} else {
			return false;
		}
	}
}
