public class RemunereSecurise extends Compte {

  private int taux;

  public RemunereSecurise(String titulaire, int solde, int taux){
    super(titulaire, solde);
    this.taux = taux;
  }

  public RemunereSecurise(String titulaire, int taux){
    super(titulaire);
    this.taux = taux;
  }
  // @Override
  // public void crediter(int montant){
  //   setSolde(getSolde()+montant);
  // } 

  @Override
  public void debiter(int montant){
    int montantFinal = getSolde()-montant;
    if(montantFinal < 0){
      System.out.println("Impossible de debiter ce compte, solde insuffisant!");
      return;
    }
    setSolde(montantFinal);
  }

  public void ajouterInteret(){
    setSolde(getSolde()*taux);
  }
}
