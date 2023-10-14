public class Agenda {

  private String nomProprietaire;
  private String prenomProprietaire;
  private int annee;
  private int nbEvt;
  
  private int[][] horaires;
  private Evenement[] evenements;

  public Agenda(String nom, String prenom, int annee){
    this.nomProprietaire = nom;
    this.prenomProprietaire = prenom;
    this.annee = annee;

    horaires = new int[365][24];
    evenements = new Evenement[365*24];
    nbEvt = 0;
  }

  public void creerEvenementPonctuel(int jour, int heureDebut, int heureFin, String lieu, String titre){
    EvenementPonctuel e = new EvenementPonctuel(jour, heureDebut, heureFin, lieu, titre);
    boolean dispo = true;

    // verif
    for(int i = heureDebut; i<heureFin; i++){
      if(horaires[jour][i] != 0){
        System.err.println("Erreur: un évenement est déja prévu pour le jour" + jour + " (heure: "+ i + ").");
        dispo = false;
        break;
      }
    }
    
    if(dispo){
      // remplissage des horaires
      for(int i = heureDebut; i<heureFin; i++){
        horaires[jour][i] = e.getNumero();
      }
      // ajout de l'évenement à la liste d'evenements
      evenements[nbEvt] = e;
      nbEvt++;
    }
  }

  public void creerEvenementRegulier(int jour, int heureDebut, int heureFin, String lieu, String titre, int periode, int nbrFois){
    
    int i = 0; //i compteur
    int jourTemp = jour; //jour auquel on en est
    int vraiNbrFois = 0; //nombre de fois ou on doit vraiment ajouter l'evt (sans depasser de l'annee)
    boolean dispo;

    // calcul de vraiNbrFois
    while(i < nbrFois){
      jourTemp = jour+periode;
      if(jourTemp>365){
        System.err.println("Erreur, l'evenement regulier depasse de l'annee! (jour:" + jour + ")");
      }
      else{ 
        vraiNbrFois++; 
      }
    }

    //pour chaque jour (incrémenté par période) dans l'année:
    for(i = jour; i<vraiNbrFois; i+=periode){
      
      dispo = true;
      Evenement e = new Evenement(jour, heureDebut, heureFin, lieu, titre, periode, nbreFois);
      // verification que le créneau pour le jour i est dispo:
      for(int j = heureDebut; j<heureFin; j++){
        if(horaires[i][j] != 0){
          System.err.println("Erreur: un évenement est déjà prévu pour le jour" + i + "(heure: )"+ j +").");
          dispo = false;
          break;
        }
      }

      // si le jour est dispo, on l'ajoute
      if(dispo){
        for(int k = heureDebut; k<heureFin; k++){
          horaires[i][k] = e.getNumero(); //i = le jour, k = l'heure
        }
        evenements[nbEvt] = e;
        nbEvt++;
      }
    }
  }

}
