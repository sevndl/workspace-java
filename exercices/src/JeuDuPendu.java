import java.util.Scanner;

public class JeuDuPendu {
  private String motMasque;

  public JeuDuPendu(String aDeviner) {
    this.motMasque = aDeviner.toLowerCase();
  }

  public boolean proposer(char lettreProposee) {
    if (motMasque.indexOf(lettreProposee) != -1) {
      System.out.println("Présente, à l'index : " + motMasque.indexOf(lettreProposee));
      return true;
    } else {
      System.out.println("La lettre n'est pas dans le mot.");
      return false;
    }
  }

  public String getSolution() {
    return this.motMasque;
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
