public class Agenda {

  private String nomProprietaire;
  private String prenomProprietaire;
  private int annee;
  private int nbEvt;
  
  private int[][] horaires; // dim1 = jour(365), dim2 = heure (24)
  private Evenement[] evenements; // il peut y avoir 1 evt par heure -> taille = 24*365

  public Agenda(String nom, String prenom, int annee){
    this.nomProprietaire = nom;
    this.prenomProprietaire = prenom;
    this.annee = annee;

    horaires = new int[365][24];
    evenements = new Evenement[365*24];
    nbEvt = 0;
  }

  // vérifie qu'il n'y a aucun evenement enregistré entre heureDebut et heureFin
  // retroune true si le créneau est dispo, false sinon
  private boolean verifierDispo(int jour, int heureDebut, int HeureFin){
    for (int i = heureDebut; i<heureFin; i++){
      if(horaires[jour][i] != 0){
        return false;
      }
    }
    return true;
  }

  public boolean evtPresent(int numEvt){
    for(Evenement e : evenements){
      if(e.getNumero() == numEvt){
        return true;
      }
    }
    return false;
  }

  Evenement getEvtTab(int numEvt){
    for(Evenement e : evenements){
      if(e.getNumero() == numEvt){
        return e;
      }
    }
    return null;
  }

  private void supprimeEvtToTabEvt(Evenement e){
    for(Evenement x : evenements){
      if(x.getNumero() == e.getNumero()){
        x.supprimeElement(this);
        return;
      }
    }
    System.out.println("Impossible de supprimer l'évenement '" + e.getTitre() + "' car il est introuvable dans l'agenda.");
  }

  public void creerEvenementPonctuel(int jour, int heureDebut, int heureFin, String lieu, String titre) throws Exception{
    EvenementPonctuel e = new EvenementPonctuel(jour, heureDebut, heureFin, lieu, titre);
    boolean dispo = verifierDispo(jour, heureDebut, HeureFin);
    
    if(!dispo){
      throw new Exception("Erreur lors de la création de l'evenement ponctuel '" + titre + "', cette date n'est pas disponible.");
      return;
    }

    // remplissage des horaires
    for(int i = heureDebut; i<heureFin; i++){
      horaires[jour][i] = e.getNumero();
    }
    // ajout de l'évenement à la liste d'evenements
    evenements[nbEvt] = e;
    nbEvt++;
  }

  public void creerEvenementRegulier(int jour, int heureDebut, int heureFin, String lieu, String titre, int periode, int nbrFois) throws Exception{
    
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
    System.out.println("L'évenemnt régulier '" + titre + "' sera ajouté " + vraiNbrFois + " fois. (Prévu: " + nbrFois + " fois)");

    //pour chaque jour (incrémenté par période) dans l'année:
    for(i = jour; i<vraiNbrFois; i+=periode){
      
      Evenement e = new Evenement(i, heureDebut, heureFin, lieu, titre);
      dispo = verifierDispo(i, heureDebut, HeureFin);
      
      if(!dispo){
        throw new Exception("Erreur, lors de la création de l'évenement régulier '" + titre + "', pour le jour " + i + 
          ", un autre évenement est déjà prévu à cette date.");
        break;
      }

      // si le jour est dispo, on l'ajoute
      if(dispo){
        for(int j = heureDebut; j<heureFin; j++){
          horaires[i][j] = e.getNumero(); //i = le jour, j = l'heure
        }
        evenements[nbEvt] = e;
        nbEvt++;
      }
    }
  }

}
