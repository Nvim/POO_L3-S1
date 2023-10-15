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
  
  @Override
  public String toString(){
    String str = "\t*** Agenda de " + prenomProprietaire + " " + nomProprietaire + "pour l'année " + annee + " ***\n\n";
    for(int i = 0; i<nbEvt; i++){
      if(evenements[i] != null){ // un evenement peut avoir été supprimé, ce qui laisse un trou
        str += evenements[i].toString();
      }
    }
    return str;
  }

  // vérifie qu'il n'y a aucun evenement enregistré entre heureDebut et heureFin
  // retroune true si le créneau est dispo, false sinon
  private boolean verifierDispo(int jour, int heureDebut, int heureFin){
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

  // ajoute l'evenement au tableau d'evenements
  private void addEvtToTabEvt(Evenement e) throws Exception{
    if(evenements.length > nbEvt){
      evenements[nbEvt] = e;
      nbEvt++;
      return;
    }
    throw new Exception("Erreur: le tableau d'evenements est plein. Impossible d'ajouter de nouveaux evenements");
  }

  // ajoute l'evenement au tableau des horaires
  private void addEvtToPlageHoraire(Evenement e){
    for(int i = e.getHDeb(); i < e.getHFin(); i++){
      horaires[e.getJour()][i] = e.getNumero();
    }
  }

  // supprime l'evenement du tableau d'evenements
  private void supprimeEvtToTabEvt(Evenement e){
    // for(Evenement x : evenements){
    //   if(x.getNumero() == e.getNumero()){
    //     x = null;
    //     return;
    //   }
    // }
    for(int i = 0; i<nbEvt; i++){
      if(evenements[i].getNumero() == e.getNumero()){
        evenements[i] = null;
        return;
      }
    }
    System.out.println("Impossible de supprimer l'évenement '" + e.getTitre() + "' car il est introuvable dans l'agenda.");
  }

  // supprime l'évenement du tableau horaires
  private void supprimeEvtToPlageHoraire(Evenement e){
    if(!evtPresent(e.getNumero())){
      System.out.println("Erreur supprimeEvtToPlageHoraire: l'evenement n'est pas présent dans l'agenda.");
      return;
    }
    for(int i = e.getHDeb(); i< e.getHFin(); i++){
      horaires[e.getJour()][i] = 0;
    }
  }

  // supprime l'evenement du tableau d'evenements et du tableau horaires.
  public void supprimeEvt(int numEvt){
    if(!evtPresent(numEvt)){
      System.out.println("Erreur supprimeEvt: l'evenement n'est pas présent dans l'agenda.");
      return;
    }
    Evenement e = getEvtTab(numEvt);
    if(e == null){
      System.out.println("ERREUR supprimeEvt: e est nul alors qu'il devrait etre présent dans l'agenda.");
      return;
    }
    System.out.println("Suppression de l'evenement " + numEvt + "!");
    supprimeEvtToPlageHoraire(e);
    supprimeEvtToTabEvt(e);
  }

  public void creerEvenementPonctuel(int jour, int heureDebut, int heureFin, String lieu, String titre) throws Exception{
    EvenementPonctuel e = new EvenementPonctuel(jour, heureDebut, heureFin, lieu, titre);
    boolean dispo = verifierDispo(jour, heureDebut, heureFin);
    
    if(!dispo){
      throw new Exception("Erreur lors de la création de l'evenement ponctuel '" + titre + "', cette date n'est pas disponible.");
    }

    addEvtToPlageHoraire(e); // remplissage des horaires
    addEvtToTabEvt(e); // ajout de l'évenement à la liste d'evenements
  }

  private int getVraiNbrFois(int jourDebut, int periode, int nbrFois){
    int i = 0;
    int jourTemp = jourDebut;
    int vraiNbrFois = 0;

    if(jourDebut < 366){
      vraiNbrFois = 1;
      i=1;
    }

    while (i < nbrFois){
      jourTemp += periode;
      if(jourTemp>365){
        System.err.println("Attention: l'evenement régulier depasse de l'année! (jour:" + jourTemp + ")");
      }
      else{
        vraiNbrFois++;
      }
      i++;
    }
    return vraiNbrFois;
  }

  public void creerEvenementRegulier(int jour, int heureDebut, int heureFin, String lieu, String titre, int periode, int nbrFois) throws Exception{
    
    boolean dispo;
    int vraiNbrFois = getVraiNbrFois(jour, periode, nbrFois); //nombre de fois ou on doit vraiment ajouter l'evt (sans depasser de l'annee)
    if(vraiNbrFois != nbrFois){
      System.out.println("L'évenemnt régulier '" + titre + "' sera ajouté que " + vraiNbrFois + " fois. (Prévu: " + nbrFois + " fois)");
    }

    int i = 0;
    int jourTemp = jour;
    while(i<vraiNbrFois){
      Evenement e = new EvenementPonctuel(jourTemp, heureDebut, heureFin, lieu, titre);
      dispo = verifierDispo(jourTemp, heureDebut, heureFin);

      if(!dispo){
        throw new Exception("Erreur, lors de la création de l'évenement régulier '" + titre + "', pour le jour " + i + 
          ", un autre évenement est déjà prévu à cette date.");
      }

      if(dispo){
        addEvtToTabEvt(e);
        addEvtToPlageHoraire(e);
      }
      i++;
      jourTemp += periode;
    }
  }

}
