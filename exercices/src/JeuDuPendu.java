import java.util.Scanner;

public class JeuDuPendu {
  private String mot;
  private String motMasque;
  private int nbTentatives = 6;

  public JeuDuPendu(String aDeviner) {
    this.mot = aDeviner.toLowerCase();
    this.motMasque = this.mot;
    this.motMasque = this.motMasque.replaceAll("[a-z]", "_");
  }

  public boolean proposer(char lettreProposee) {
    int occurences = 0;
    int length = this.mot.length();

    for (int index = 0; index < length; index += 1) {
      if (lettreProposee == this.mot.charAt(index)) {
        StringBuilder str = new StringBuilder(this.motMasque);
        str.setCharAt(index, lettreProposee);
        this.motMasque = str.toString();
        occurences += 1;
      }
    }
    if (occurences >= 1) {
      return true;
    } else {
      this.nbTentatives -= 1;
      return false;
    }
  }

  public int getNbTentativesRestantes() {
    return this.nbTentatives;
  }

  public boolean isPartieGagnee() {
    for (int index = 0; index < this.motMasque.length(); index += 1) {
      if (motMasque.charAt(index) == '_') {
        return false;
      }
    }
    if (this.nbTentatives > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isPartieTerminee() {
    if (this.nbTentatives == 0 || this.motMasque.equals(this.mot)) {
      return true;
    } else {
      return false;
    }
  }

  public String getMotMasque() {
    return this.motMasque;
  }

  public String getSolution() {
    return this.mot;
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
