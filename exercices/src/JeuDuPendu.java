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

  public static void main(String[] args) {
    JeuDuPendu pendu = new JeuDuPendu("feuille");

    pendu.proposer('u');
    pendu.proposer('z');
  }
}
