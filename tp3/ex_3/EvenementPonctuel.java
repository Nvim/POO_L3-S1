public class EvenementPonctuel extends Evenement{

  public EvenementPonctuel(int jour, int heureDebut, int heureFin, String lieu, String titre){
    super(jour, heureDebut, heureFin, lieu, titre);
  }

  @Override
  public void enregistreEvenement(Agenda agendaUnAn){
    agendaUnAn.creerEvenementPonctuel(getJour(), getHDeb(), getHFin(), getLieu(), getTitre());
  }

  @Override
  public void supprimeElement(){
    System.out.println("caca");
  }
}
