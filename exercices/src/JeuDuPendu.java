import java.util.Scanner;

public class JeuDuPendu {
  private String mot;
  private String motMasque;
  private int nbTentatives = 6;

  public JeuDuPendu(String aDeviner) {
    mot = aDeviner.toLowerCase();
    motMasque = mot;
    motMasque = motMasque.replaceAll("[a-z]", "_");
  }

  public boolean proposer(char lettreProposee) {
    int index = 0;
    int occurences = 0;

    for (char c : mot.toCharArray()) {
      if (lettreProposee == c) {
        char lettreActuelle = motMasque.charAt(index);
        motMasque = motMasque.replace(lettreActuelle, lettreProposee);
        occurences += 1;
      }
      index += 1;
    }
    if (occurences >= 1) {
      return true;
    } else {
      nbTentatives -= 1;
      return false;
    }
  }

  public int getNbTentativesRestantes() {
    return nbTentatives;
  }

  public boolean isPartieGagnee() {
    for (char c : motMasque.toCharArray()) {
      if (c == '_') {
        return false;
      }
    }
    if (nbTentatives > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isPartieTerminee() {
    if (nbTentatives == 0 || isPartieGagnee()) {
      return true;
    } else {
      return false;
    }
  }

  public String getMotMasque() {
    String motMasqueString = motMasque.toString();
    return motMasqueString;
  }

  public String getSolution() {
    String motString = mot.toString();
    return motString;
  }


  public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		JeuDuPendu jeuDuPendu = new JeuDuPendu("feuille");

		do {
			String motMasque = jeuDuPendu.getMotMasque();
			int nbTentativesRestantes = jeuDuPendu.getNbTentativesRestantes();
			System.out.printf("Le mot : %s\n", motMasque);
			System.out.printf("Proposez une lettre (il reste %d tentatives) : ", nbTentativesRestantes);
			String ligne = scanner.nextLine();
			if (ligne.length() != 1) {
				System.out.println("Vous devez saisir une seule lettre!");
				continue;
			}
			char lettre = ligne.charAt(0);
			if (! jeuDuPendu.proposer(lettre)) {
				System.out.println("Cette lettre n'est pas présente dans le mot à trouver.");
			}
		} while(! jeuDuPendu.isPartieTerminee());

		if (jeuDuPendu.isPartieGagnee()) {
			System.out.println("Bravo, vous avez gagné !");
		} else {
			System.out.printf("Vous avez perdu. Le mot à trouver était %s.\n", jeuDuPendu.getSolution());
		}
	}
}
