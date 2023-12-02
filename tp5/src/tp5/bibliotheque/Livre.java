
package tp5.bibliotheque;

/**
 * Livre
 */
public class Livre {

  int annee;
  String titre, auteur, isbn;

  public Livre(String isbn, String titre, String auteur, int annee){
    this.isbn = isbn;
    this.annee = annee;
    this.titre = titre;
    this.auteur = auteur;
  }

  public String toString(){
    String str = "- Titre: " + titre + ", Auteur: " + auteur + ", ISBN: " + isbn + ".";
    return str;
  }
}
