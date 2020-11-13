import javax.swing.text.StyledEditorKit;

public class Rectangle {
  private double longueur;
  private double largeur;

  public Rectangle(double longueur, double largeur) {
    this.longueur = longueur;
    this.largeur = largeur;
  }

  public Rectangle(double cote) {
    this.longueur = cote;
    this.largeur = cote;
  }

  public Rectangle(Rectangle r) {
    this(r.longueur, r.largeur);
  }

  public boolean equals(Object object) {
		if (object instanceof Rectangle) {
			Rectangle f = (Rectangle) object;
			return (this.getLongueur() == f.getLongueur() && this.getLargeur() == f.getLargeur());
		} else {
			return false;
		}
	}

  public double getLongueur() {
    return this.longueur;
  }

  public void setLongueur(double valeur) {
    this.longueur = valeur;
  }

  public double getLargeur() {
    return this.largeur;
  }

  public void setLargeur(double valeur) {
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

  public static void main(String[] args) {

		Rectangle r = new Rectangle(5, 10);
		r.setLargeur(10);
    r.setLongueur(20);
    Rectangle r2 = new Rectangle(r);

    if (r.equals(r2)) {
      System.out.println("r = r2");
    }

		System.out.printf("Un rectangle de largeur %.2f et de longueur %.2f\n", r.getLargeur(), r.getLongueur());
		System.out.printf("Le perimettre de ce rectangle est %.2f\n", r.getPerimetre());
		System.out.printf("L'aire de ce rectangle est %.2f\n", r.getAire());
		System.out.println(r.isCarre() ? "Ce rectangle est un carre" : "Ce rectangle n'est pas un carre");

		r.transpose();
		System.out.printf("Un rectangle de largeur %.2f et de longueur %.2f\n", r.getLargeur(), r.getLongueur());
		System.out.printf("Le perimettre de ce rectangle est %.2f\n", r.getPerimetre());
		System.out.printf("L'aire de ce rectangle est %.2f\n", r.getAire());
		System.out.println(r.isCarre() ? "Ce rectangle est un carre" : "Ce rectangle n'est pas un carre");

		r.setLargeur(r.getLongueur());
		System.out.printf("Un rectangle de largeur %.2f et de longueur %.2f\n", r.getLargeur(), r.getLongueur());
		System.out.printf("Le perimettre de ce rectangle est %.2f\n", r.getPerimetre());
		System.out.printf("L'aire de ce rectangle est %.2f\n", r.getAire());
    System.out.println(r.isCarre() ? "Ce rectangle est un carre" : "Ce rectangle n'est pas un carre");
    
    /////

    System.out.printf("Un rectangle de largeur %.2f et de longueur %.2f\n", r2.getLargeur(), r2.getLongueur());
		System.out.printf("Le perimettre de ce rectangle est %.2f\n", r2.getPerimetre());
		System.out.printf("L'aire de ce rectangle est %.2f\n", r2.getAire());
		System.out.println(r2.isCarre() ? "Ce rectangle est un carre" : "Ce rectangle n'est pas un carre");

		r2.transpose();
		System.out.printf("Un rectangle de largeur %.2f et de longueur %.2f\n", r2.getLargeur(), r2.getLongueur());
		System.out.printf("Le perimettre de ce rectangle est %.2f\n", r2.getPerimetre());
		System.out.printf("L'aire de ce rectangle est %.2f\n", r2.getAire());
		System.out.println(r2.isCarre() ? "Ce rectangle est un carre" : "Ce rectangle n'est pas un carre");

		r2.setLargeur(r2.getLongueur());
		System.out.printf("Un rectangle de largeur %.2f et de longueur %.2f\n", r2.getLargeur(), r2.getLongueur());
		System.out.printf("Le perimettre de ce rectangle est %.2f\n", r2.getPerimetre());
		System.out.printf("L'aire de ce rectangle est %.2f\n", r2.getAire());
		System.out.println(r2.isCarre() ? "Ce rectangle est un carre" : "Ce rectangle n'est pas un carre");
	}
}