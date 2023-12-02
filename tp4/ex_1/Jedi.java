import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Jedi extends Personnage {

  private Sabre sabreLaser; 

  public static List<Jedi> genererListJedi(int n){
    ArrayList<Jedi> list = new ArrayList<Jedi>(n);
    Random random = new Random();
    for(int i = 0; i < n; i++){
      try {
        Jedi c = new Jedi("Jedi" + i, 100, 0, 0, random.nextInt(n - 10 + 1) + 10 , "Vert");
        list.add(c);
      } catch (Exception e) {
        System.err.println("Jedi mort initialisé!");
      }
    }
    return list;
  }

  public static List<Jedi> trier(List<Jedi> liste){
    List<Jedi> res = new ArrayList<Jedi>(liste.size());

    for(int i = 0; i < liste.size(); i++){
      res.add(liste.get(i));
    }

    for(int i = 0; i<res.size() -1; i++){
      for(int j = 0; j<res.size() -1 - i; j++){
        if(res.get(j).getForce() > res.get(j+1).getForce()){
          Jedi tmp = res.get(j);
          res.set(j, res.get(j+1));
          res.set(j+1, tmp);
        }
      }
    }

    return res;
  }

  public Jedi(String nom, int vie, int x, int y, int force, String couleur) throws MortException{
    setNom(nom);
    setVie(vie);
    setVitesse(5);
    setX(x);
    setY(y);
    setForce(force);
    a = new Sabre(couleur);
    sabreLaser = (Sabre) a;

    if(checkVivant() == false){
      throw new MortException("Le jedi " + nom + "ne peut pas etre cree, il est deja mort");
    }
  }

  @Override
  public String toString(){
    return this.getNom() + ", Force: " + this.getForce() + ".\n";
  }

  @Override
  public void parler() throws MortException {
    if(checkVivant() == false){
      throw new MortException("Le jedi " + getNom() + " est mort !");
    }
    System.out.println("--- " + getNom() + " parle: ---");
    System.out.println("    Que la force soit avec vous    ");
  }

  public void coupSabre(Personnage p) throws MortException {
    if(checkVivant() == false){
      throw new MortException("Le jedi " + getNom() + " est mort !");
    }
    if(sabreLaser.getAllumee() == false){
      System.out.println("*** " + getNom() + ": Impossible d'attaquer, le sabre est eteint. ***");
      return;
    } 
    p.seBlesse(sabreLaser, this);
  }

  @Override
  public void seBlesse(Arme a, Personnage p) throws MortException {
    if(checkVivant() == false){
      throw new MortException("Le jedi " + getNom() + " est mort !");
    }
    int degatsSubits = a.getPuissance() * p.getForce();
    setVie(getVie() - degatsSubits);
    System.out.println("___ " + getNom() + " est attaque par " + p.getNom() + " et perd " 
    + degatsSubits + " points de vie. ___");
    System.out.println("___ Vie restante: " + getVie() + " ___");
    
    if(getVie() <= 0){
      System.out.println(" Le Jedi " + getNom() + " a ete tue par " + p.getNom() + " !");
    }
  }
  
}
