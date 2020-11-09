import java.util.ArrayList;
import java.util.List;

public class AffichageNombresPremiersAmeliore {
	public static void main(String[] args) {
		List<Integer> nombresPremiers = new ArrayList<>();
		int nbNombresPremiers = 0;
		
		for (int i = 2; i <= 1000; i++) {
			boolean estUnNombrePremier = true;
			for (int j : nombresPremiers) {
				if (i % j == 0) {
					estUnNombrePremier = false;
					break;
				}
			}
			if (estUnNombrePremier) {
				nbNombresPremiers += 1;
				nombresPremiers.add(i);
			}
		}

		for (int i : nombresPremiers) {
			System.out.println(i);
		}
	}

}