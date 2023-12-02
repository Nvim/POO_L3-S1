package tp5.bibliotheque;

/**
 * Utilisateur
 */
public class Utilisateur {

  String nom, prenom;
  String id;

  public Utilisateur(String nom, String prenom, String id){
    this.nom = nom;
    this.prenom = prenom;
    this.id = id;
  }

  public String toString(){
    String str = "- Nom: " + nom + ", Prénom: " + prenom + ", ID: " + id + ".";
    return str;
  }
}
