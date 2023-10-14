public class EvenementRegulier extends Evenement{

  private int periode; // tous les combien de jours?
  private int nbreFois; // combien de fois total (au cas ou tu veux pas que ça fasse toute l'année)

  public EvenementRegulier(int jour, int heureDebut, int heureFin, String lieu, String titre, int periode, int nbreFois){
    super(jour, heureDebut, heureFin, lieu, titre);
    this.periode = periode;
    this.nbreFois = nbreFois;
  }

  @Override
  public void enregistreEvenement(Agenda agendaUnAn){
    try {
      agendaUnAn.creerEvenementRegulier(getJour(), getHDeb(), getHFin(), getLieu(), getTitre(), periode, nbreFois);
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
      System.err.println("Impossible d'ajouter l'evenement '" + this.getTitre() + "':");
      System.err.println(e.getMessage());
    }
  }

  @Override
  public String toString(){
    String str = super.toString();
    str += "\nType d'evenement: Regulier";
    str += "\nNombre de répetitions: " + nbreFois;
    str += "\nPériode: " + periode;
    str += "\n **********************************\n";
    return str;
  }
}
