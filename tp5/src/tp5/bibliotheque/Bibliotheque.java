package tp5.bibliotheque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import java.nio.file.*;

/**
 * Bibliotheque
 */
public class Bibliotheque {

  // ArrayList<Livre> livres;
  // ArrayList<Utilisateur> utilisateurs;
  Map<String, Livre> livres;
  Map<String, Utilisateur> utilisateurs;

  public Bibliotheque(){
    livres = new HashMap<String, Livre>();
    utilisateurs = new HashMap<String, Utilisateur>();
  }

  public void ajouterUtilisateur(Utilisateur u){
    utilisateurs.put(u.id, u);
  }

  public void ajouterLivre(Livre l){
    livres.put(l.isbn, l);
  }

  public void supprimerUtilisateur(Utilisateur u){
    utilisateurs.remove(u.id);
  }

  public void supprimerLivre(Livre l){
    livres.remove(l.isbn);
  }

  public boolean chargerLivres(String cheminFichier){
    String livres;
    try {
      livres = Files.readString(Paths.get(cheminFichier));
    } catch (Exception e) {
      System.out.println("ERREUR Path");
      return false;
    }
    
    List<String> listeMots = List.of(livres.split("\n|,"));

    for(int i = 4; i<listeMots.size(); i+=4){
      Livre l;
      try {
        l = new Livre(listeMots.get(i), listeMots.get(i+1), listeMots.get(i+2), Integer.parseInt(listeMots.get(i+3)));
      } catch (Exception e) {
        System.err.println("ERREUR format nombre (comment c'est possible??)");
        e.printStackTrace();
        return false;
      }
      this.ajouterLivre(l);
    }

    return true;
  }

  public String toString(){
    String str;
    str = " *** Bibliotheque: ***\n\tUtilisateurs:\n";

    for(Map.Entry<String, Utilisateur> entry : utilisateurs.entrySet()){
      str+= entry.getValue().toString() + "\n";
    }
    str+= "\n\tLivres:\n";
    for(Map.Entry<String, Livre> entry : livres.entrySet()){
      str+= entry.getValue().toString() + "\n";
    }
    return str;
  }
}
