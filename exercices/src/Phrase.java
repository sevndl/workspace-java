public class Phrase {
  private String phrase = "bonjour";

  public String ajouter(String mot) {
    
    return phrase + mot;
  }

  public int getNbLettres() {
    int cpt = 0;
    for (char c : phrase.toCharArray()) {
      cpt += 1;
    }
    return cpt;
  }

  public static void main(String[] args) {
    Phrase phrase1 = new Phrase();
  
    // phrase.ajouter("Salut la moule");
    System.out.println(phrase1);
    System.out.println(phrase1.getNbLettres());
  }
}