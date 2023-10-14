public abstract class Personnage {

  private String nom;
  private int vie, x, y, vitesse, force;
  Arme a;

  public void allumerArme(){
    System.out.println("-- " + nom + " allume son arme! --" );
    a.allumer();
  }
  public void eteindreArme(){
    System.out.println("-- " + nom + " eteint son arme! --" );
    a.eteindre();
  }

  public boolean checkVivant(){
    if (vie <= 0){
      return false;
    }
    return true;
  }

  //public abstract void seDeplace(int dx, int dy, int dt);

  // décrémente la vie du Personnage par la puissance de l'arme * la force du Personnage p
  public abstract void seBlesse(Arme a, Personnage p) throws MortException;

  public abstract void parler() throws MortException;

  public void setNom(String nom){
    this.nom = nom;
  }
  public void setVie(int vie){
    this.vie = vie;
  }
  public void setVitesse(int vitesse){
    this.vitesse = vitesse;
  }
  public void setForce(int force){
    this.force = force;
  }
  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
  //
  public String getNom(){
    return nom;
  }
  public int getVie(){
    return vie;
  }
  public int getForce(){
    return force;
  }
}

