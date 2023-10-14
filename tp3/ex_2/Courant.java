public class Courant extends Compte {

  public Courant(String titulaire, int solde){
    super(titulaire, solde);
  }

  public Courant(String titulaire){
    super(titulaire);
  }
  // @Override
  // public void crediter(int montant){
  //   setSolde(getSolde()+montant);
  // } 

  @Override
  public void debiter(int montant){
    setSolde(getSolde()-montant);
  }
}
