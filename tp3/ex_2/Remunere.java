public class Remunere extends Compte {

  private int taux;

  public Remunere(String titulaire, int taux, int solde){
    super(titulaire, solde);
    this.taux = taux;
  }

  public Remunere(String titulaire, int taux){
    super(titulaire);
    this.taux = taux;
  }
  // @Override
  // public void crediter(int montant){
  //   setSolde(getSolde()+montant);
  // } 

  @Override
  public void debiter(int montant){
    setSolde(getSolde()-montant);
  }

  public void ajouterInteret(){
    setSolde(getSolde()*taux);
  }
}
