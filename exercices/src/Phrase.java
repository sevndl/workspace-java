public class Phrase {
  
  private String phrase = "";

  public String ajouter(String aAjouter) {
    phrase = phrase + aAjouter + " ";
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
    // phrase.setSeparateur(" et encore ");
    // phrase.ajouter("des mots", 3);
    // phrase.setSeparateur(' ');
    // phrase.ajouter("toujours", "et", "encore");

    System.out.println(phrase);
    System.out.println(phrase.getNbLettres());
  }
}