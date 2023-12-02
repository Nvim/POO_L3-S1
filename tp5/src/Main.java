import java.util.ArrayList;

import tp5.bibliotheque.Bibliotheque;
import tp5.bibliotheque.Livre;
import tp5.bibliotheque.Utilisateur;

/**
 * GestionBiblio
 */
public class Main {

  public static void main(String[] args) {
    
    Livre livre1 = new Livre("1234", "titre", "auteur", 1234);

    Bibliotheque b = new Bibliotheque();
    b.ajouterLivre(livre1);
    b.ajouterUtilisateur(new Utilisateur("Naim", "Chefirat", "111111112"));
    System.out.println(b.chargerLivres("../lib/liste_livres.csv"));

    System.out.println(b.toString());

  }
}
