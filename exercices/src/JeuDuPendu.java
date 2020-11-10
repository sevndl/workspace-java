import java.util.Scanner;

public class JeuDuPendu {
  private char [] mot;
  private char [] motMasque;
  private int nbTentatives = 6;
  private boolean estTrouve = false;

  public JeuDuPendu(String aDeviner) {
    String aDevinerMinuscules = aDeviner.toLowerCase();
    this.mot = aDevinerMinuscules.toCharArray();
    for (char c : this.motMasque) {
      this.motMasque[c] = '_';
    }
  }

  public boolean proposer(char lettreProposee) {
    int index = 0;
    int occurences = 0;

    for (char c : this.mot) {
      if (lettreProposee == c) {
        this.motMasque[index] = lettreProposee;
        occurences += 1;
      }
      index += 1;
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

  // public boolean isPartieGagnee() {
    
  // }

  // public boolean isPartieTerminee() {

  // }

  public String getMotMasque() {
    String motMasqueString = this.motMasque.toString();
    return motMasqueString;
  }

  public String getSolution() {
    String motString = this.mot.toString();
    return motString;
  }


  // public static void main(String[] args) {
	// 	Scanner scanner = new Scanner(System.in);
	// 	JeuDuPendu jeuDuPendu = new JeuDuPendu("feuille");

	// 	do {
	// 		String motMasque = jeuDuPendu.getMotMasque();
	// 		int nbTentativesRestantes = jeuDuPendu.getNbTentativesRestantes();
	// 		System.out.printf("Le mot : %s\n", motMasque);
	// 		System.out.printf("Proposez une lettre (il reste %d tentatives) : ", nbTentativesRestantes);
	// 		String ligne = scanner.nextLine();
	// 		if (ligne.length() != 1) {
	// 			System.out.println("Vous devez saisir une seule lettre!");
	// 			continue;
	// 		}
	// 		char lettre = ligne.charAt(0);
	// 		if (! jeuDuPendu.proposer(lettre)) {
	// 			System.out.println("Cette lettre n'est pas présente dans le mot à trouver.");
	// 		}
	// 	} while(! jeuDuPendu.isPartieTerminee());

	// 	if (jeuDuPendu.isPartieGagnee()) {
	// 		System.out.println("Bravo, vous avez gagné !");
	// 	} else {
	// 		System.out.printf("Vous avez perdu. Le mot à trouver était %s.\n", jeuDuPendu.getSolution());
	// 	}
	// }
}
