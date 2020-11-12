public class DemoFormation {
	public static void main(String[] args) {
		Formation formation1 = new Formation("test");
		formation1.ajouterModule(new Cours(50, 15, "cours POO", 60));
		formation1.ajouterModule(new Tutoriel("lien", "cours POO", 120));
		formation1.ajouterModule(new Projet(5, 4, "cours POO", 30));
		
		System.out.println(formation1.getDuree());
		System.out.println(formation1.getNbMinStagiaires());
	}
}
