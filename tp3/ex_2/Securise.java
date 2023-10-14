public class Securise extends Compte {

  public Securise(String titulaire, int solde){
    super(titulaire, solde);
  }

  public Securise(String titulaire){
    super(titulaire);
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
}
