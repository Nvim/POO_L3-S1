public class SoldatClone extends Personnage {

  private Blaster blaster;

  public SoldatClone(String nom, int x, int y) throws MortException{
    setNom(nom);
    setVie(100);
    setVitesse(4);
    setForce(2);
    setX(x);
    setY(y);
    a = new Blaster();
    blaster = (Blaster) a;
    if(checkVivant() == false){
      throw new MortException("Le clone " + nom + "ne peut pas etre cree, il est deja mort");
    }
  }

  @Override
  public void parler() throws MortException {
    if(checkVivant() == false){
      throw new MortException("Le Clone " + getNom() + " est mort!");
    }
    System.out.println("--- " + getNom() + " parle: ---");
    System.out.println("    Je m'appelle " + getNom() + ".");
  }

  public void tireBlaster(Personnage p) throws MortException {
    if(checkVivant() == false){
      throw new MortException("Le Clone " + getNom() + " est mort!");
    }
    if(blaster.getAllumee() == false){
      System.out.println("*** " + getNom() + ": Impossible d'attaquer, le blaster est eteint! ***");
      return;
    }
    p.seBlesse(blaster, this);
  } 

  @Override
  public void seBlesse(Arme a, Personnage p) throws MortException {
    if(checkVivant() == false){
      throw new MortException("Le Clone " + getNom() + " est mort!");
    }
    int degatsSubits = a.getPuissance() * p.getForce();
    setVie(getVie() - degatsSubits);
    System.out.println("___ " + getNom() + " est attaque par " + p.getNom() + " et perd " 
    + degatsSubits + " points de vie. ___");
    System.out.println("___ Vie restante: " + getVie() + " ___");

    if(getVie() <= 0){
      System.out.println(" Le Clone " + getNom() + " a ete tue par " + p.getNom());
    }
  }
}
