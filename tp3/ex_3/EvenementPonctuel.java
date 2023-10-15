public class EvenementPonctuel extends Evenement{

  public EvenementPonctuel(int jour, int heureDebut, int heureFin, String lieu, String titre){
    super(jour, heureDebut, heureFin, lieu, titre);
  }

  @Override
  public void enregistreEvenement(Agenda agendaUnAn){
    try {
      agendaUnAn.creerEvenementPonctuel(getJour(), getHDeb(), getHFin(), getLieu(), getTitre());
    } catch (Exception e) {
      System.err.println("Impossible d'ajouter l'evenement '" + this.getTitre() + "':");
      System.err.println(e.getMessage());
    }
  }

  @Override
  public void supprimeElement(Agenda agendaUnAn){
    try {
      agendaUnAn.supprimeEvt(this.getNumero());
    } catch (Exception e) {
      System.err.println("Impossible de supprimer l'evenement '" + this.getTitre() + "':");
      System.err.println(e.getMessage());
    }
  }

  @Override
  public String toString(){
    String str = super.toString();
    str += "\nType d'evenement: Ponctuel";
    str += "\n **********************************\n";
    return str;
  }
}
