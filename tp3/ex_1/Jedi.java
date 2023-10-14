// import java.awt.Color;

public class Jedi extends Personnage {

  private Sabre sabreLaser; 

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
