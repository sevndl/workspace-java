package FiguresGeometriques;

import java.util.ArrayList;

public class FigureComposee {
  private ArrayList<Figure> liste = new ArrayList<>();

  public void ajouterFigure(Figure figure) {
    liste.add(figure);
  }

  public void ajouterFigure(FigureComposee figureComposee) {
    for (Figure f : figureComposee.liste) {
      liste.add(f);
    }
  }

  public double getPerimetre() {
    double perimetre = 0;
    for (Figure figure : liste) {
      perimetre += figure.getPerimetre();
    }
    return perimetre;
  }

  public double getAire() {
    double aire = 0;
    for (Figure figure : liste) {
      aire += figure.getAire();
    }
    return aire;
  }
}
