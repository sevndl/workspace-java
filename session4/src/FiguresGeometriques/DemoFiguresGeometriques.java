package FiguresGeometriques;

public class DemoFiguresGeometriques {
  public static void main(String[] args) {
		Figure r = new Rectangle(10, 20);
		Figure r2 = new Rectangle(10, 20);
		Figure d = new Disque(5);

		System.out.println(r.getAire());
		System.out.println(r.getPerimetre());
		System.out.println(d.getAire());
		System.out.println(d.getPerimetre());

		if (r.equals(r2)) {
			System.out.println("R = D");
		}

		FigureComposee f = new FigureComposee();
		FigureComposee f2 = new FigureComposee();
		f.ajouterFigure(new Rectangle(10, 20));
		f.ajouterFigure(new Rectangle(5, 10));
		f.ajouterFigure(new Disque(5));
		System.out.println(f.getPerimetre());
		System.out.println(f.getAire());
		f2.ajouterFigure(new Rectangle(10, 20));
		f2.ajouterFigure(new Rectangle(5, 10));
		f2.ajouterFigure(new Disque(5));
		f.ajouterFigure(f2);

		System.out.println(f.getPerimetre());
		System.out.println(f.getAire());
	}
}
