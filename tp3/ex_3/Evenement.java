public abstract class Evenement {

  private int jour, hDeb, hFin, nbEvt;
  private static int numero = 0;
  private String lieu, titre;

  public Evenement(int jour, int heureDebut, int heureFin, String lieu, String titre){
    this.jour =jour;
    this.hDeb = heureDebut;
    this.hFin = heureFin;
    this.lieu = lieu;
    this.titre = titre;
    numero++;
  }

  public abstract void enregistreEvenement(Agenda agendaUnAn);

  public abstract void supprimeElement();
  
  public String toString(){
    return "a";
  }

  public int getJour(){
    return jour;
  }

  public int getHDeb(){
    return hDeb;
  }

  public int getHFin(){
    return hFin;
  }

  public String getLieu(){
    return lieu;
  }

  public String getTitre(){
    return titre;
  }

  public int getNumero(){
    return numero;
  }
}
