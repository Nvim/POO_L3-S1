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
    agendaUnAn.creerEvenementRegulier(getJour(), getHDeb(), getHFin(), getLieu(), getTitre(), periode, nbreFois);
  }

  @Override
  public void supprimeElement(){
    System.out.println("caca");
  }

}
