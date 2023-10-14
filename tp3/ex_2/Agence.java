import java.util.ArrayList;

public class Agence {

  private String nom;
  // Compte[] comptes;
  private ArrayList<Compte> comptes;

  public Agence(String nom){
    this.nom = nom;
    comptes = new ArrayList<Compte>();
  }

  public Agence(String nom, ArrayList<Compte> comptes){
    this.nom = nom;
    this.comptes = comptes;
  }

  public void ajouter(Compte c){
    comptes.add(c);
  }

  public void supprimer(int index){
    comptes.remove(index);
  }

  public void supprimer(Compte c){
    comptes.remove(c);
  }

  public Compte extraire(int index){
    return comptes.get(index);
  }

  // public Compte extraire(Compte c){
  //   return comptes.get(c);
  // }

  public String toString(){
    String str = "\t**** Agence " + nom + ": ****\n";
    for(Compte c : comptes){
      str += c.toString(); 
    }
    return str;
  }
}
