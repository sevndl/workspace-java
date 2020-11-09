
public class NombrePremier {

	public static void main(String[] args) {
		int nbNombresPremiers = 0;
		
		for (int i = 2; i <= 1000; i++) {
			boolean estUnNombrePremier = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					// i n'est pas un nombre premier
					estUnNombrePremier = false;
					break;
				}
			}
			if (estUnNombrePremier) {
				nbNombresPremiers += 1;
			}
		}

		System.out.println(nbNombresPremiers);
	}

}