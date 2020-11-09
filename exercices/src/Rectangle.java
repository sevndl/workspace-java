public class Rectangle {
  private double longueur;
  private double largeur;

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
    if (this.largeur == this.longueur) {
      return true;
    } else {
      return false;
    }
  }

  public void transpose() {
    double temp;

    temp = this.longueur;
    this.longueur = this.largeur;
    this.largeur = temp;
  }
}
