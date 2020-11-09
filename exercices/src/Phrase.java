public class Phrase {
  
  private String phrase = "";
  private String separateur = " ";

  public void setSeparateur(String separateur) {
    this.separateur = separateur;
  }

  public void setSeparateur(char separateur) {
    String separateurStr = Character.toString(separateur);
    this.separateur = separateurStr;
  }

  public String ajouter(String aAjouter) {
    phrase = phrase + this.separateur + aAjouter;
    System.out.println(phrase);
    return phrase;
  }

  public String ajouter(String aAjouter, int nbRepetitions) {
    for (int i = 0; i < nbRepetitions; ++i) {
      phrase = phrase + this.separateur + aAjouter;
    }
    System.out.println(phrase);
    return phrase;
  }

  public int getNbLettres() {
    int cpt = 0;

    for (char ch : phrase.toCharArray()) {
      if (Character.isAlphabetic(ch)) {
        cpt += 1;
      }
    }
    return cpt;
  }

  public static void main(String[] args) {
    Phrase phrase = new Phrase();
    
    phrase.ajouter("Une");
    phrase.ajouter("classe");
    phrase.ajouter("pour");
    phrase.ajouter("ajouter");
    phrase.ajouter("des mots");
    phrase.setSeparateur(" et encore ");
    phrase.ajouter("des mots", 3);
    phrase.setSeparateur(' ');
    // phrase.ajouter("toujours", "et", "encore");

    System.out.println(phrase);
    System.out.println(phrase.getNbLettres());
  }
}