import java.lang.*;

public class Phrase {
  public String phrase = "Bonjour le monde";

  // public String ajouter(String valeur) {
  //   return phrase.concat(valeur);
  // }

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
    Phrase phrase1 = new Phrase();

    // phrase1.ajouter("Salut la moule");

    System.out.println(phrase1);
    System.out.println(phrase1.getNbLettres());
  }
}