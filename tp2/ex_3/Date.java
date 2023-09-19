public class Date {

  int jour, mois, annee;

  public String toString(){
    String str = jour + "/" + mois + "/" + annee;
    return str;
  }

  public Date(int jour, int mois, int annee) throws DateException{

    this.jour = jour;
    this.mois = mois;
    this.annee = annee;

    if((mois < 1 || mois > 12) && (jour < 1 || jour > 31)){
      throw new DateException(this, ": Le jour et le mois ne sont pas valides");
    }
    if(mois < 1 || mois > 12){
      throw new MoisException(this, ": Le mois " + mois + " n'est pas valide!");
    }

    int[] moisLongs = {1, 3, 5, 7, 8, 10, 12};
    // int[] moisCourts = {2, 4, 6, 9, 11};
    boolean moisEstCourt = true;

    for(int i : moisLongs){
      if (i == mois){ // le mois est dans la liste des mois longs
        moisEstCourt = false; // donc le mois n'est pas court
      }
    }

    if(jour > 28 && mois == 2){
      throw new JourDansMoisException(this, ": Février ne contient pas autant de jours!");
    }

    if (jour > 30 && moisEstCourt == true){
      throw new JourDansMoisException(this, ": Le mois " + mois + " ne contient pas autant de jours!");
    }

    if(jour < 1 || jour > 30){
      throw new JourException(this, ": Le jour " + jour + " n'est pas valide!");
    }
  }

}
