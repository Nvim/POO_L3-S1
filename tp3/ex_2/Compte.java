public abstract class Compte{

  private String titulaire;
  private int solde, numero;
  private static int nbTotalCompte;

  public Compte(String titulaire, int solde){
    this.solde = solde; 
    this.titulaire = titulaire;
    nbTotalCompte++;
    numero = nbTotalCompte;
  }

  public Compte(String titulaire){
    solde = 0;
    this.titulaire = titulaire;
    nbTotalCompte++;
    numero = nbTotalCompte;
  }

  public int getSolde(){
    return solde;
  }

  public abstract void debiter(int montant);

  public void crediter(int montant){
    solde = solde + montant;
  }

  public String toString(){
    String str = "*************************\ncompte n° :\t";
    str += numero;
    str += "\ntitulaire :\t " + titulaire;
    str += "\nsolde :\t" + solde;
    str += "\n*************************";
    return str;
  }

  public void setSolde(int nouveauSolde){
    solde = nouveauSolde;
  }
}
