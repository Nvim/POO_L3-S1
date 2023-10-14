public class Arme {

  private boolean allume;
  private int puissance;

  public Arme(int puissance){
    this.puissance = puissance;
    this.allume = false;
  }

  public void allumer(){
    this.allume = true;
  }
  public void eteindre(){
    this.allume = false;
  }

  public boolean getAllumee(){
    return allume; 
  }
  public int getPuissance(){
    return puissance;
  }
}
