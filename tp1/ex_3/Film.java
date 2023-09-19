//valentin.bouquet@lecnam.net
public class Film {

  private String titre;
  private String realisateur;
  private String[] acteurs;
  private String pays;
  private int annee;
  private int dureeMinutes;
  static private int compteur = 0;

  public Film(String titre, String realisateur){
    this.titre = titre;
    this.realisateur = realisateur;
    compteur++;
  }

  public Film(String titre, String realisateur, int annee, int dureeMinutes){
    this.titre = titre;
    this.realisateur = realisateur;
    this.annee = annee;
    this.dureeMinutes = dureeMinutes;
    compteur++;
  }

  public Film(String titre, String realisateur, String[] acteurs, String pays, int annee, int dureeMinutes)throws Exception{

    if(annee < 1891 || annee > 2023){
      throw new Exception("Erreur, annee invalide");
    }

    this.titre = titre;
    this.realisateur = realisateur;
    this.acteurs = acteurs;
    this.pays = pays;
    this.annee = annee;
    this.dureeMinutes = dureeMinutes;
    compteur++;
  }

  public String getTitre(){
    return this.titre;
  }
  public String getRealisateur(){
    return this.realisateur;
  }
  public String[] getActeurs(){
    return this.acteurs;
  }
  public String getPays(){
    return this.pays;
  }
  public int getAnnee(){
    return this.annee;
  }
  public int getDuree(){
    return this.dureeMinutes;
  }
  public int getCompteur(){
    return compteur;
  }

  // Setter:
  public void setTitre(String titre){
    this.titre = titre;
  }
  public void setRealisateur(String realisateur){
    this.realisateur = realisateur;
  }
  public void setActeurs(String[] acteurs){
    this.acteurs = acteurs;
  }
  public void setPays(String pays){
    this.pays = pays;
  }
  public void setDuree(int dureeMinutes){
    this.dureeMinutes = dureeMinutes;
  }

  public void setAnnee(int annee){
    if(annee < 1891 || annee > 2023 ){
      System.out.println("Erreur, annee invalide.");
      return;
    }
    this.annee = annee;
  }

  // utiliser les accesseurs est inutile ici, car on est dans
  // la classe
  public String toString(){
    String str = "Titre: " + this.titre +
    "\nRealisateur " + this.realisateur +
    "\nActeurs principaux " + this.acteurs +
    "\nPays: " + this.pays +
    "\nAnnee de sortie: " + this.annee +
    "\nDuree: " + this.dureeMinutes;

    return str;
  }

  /*
   * Questions:
   * Pourquoi ne pas juste prendre un Film en arg ?
   * (Vérifie les TP de l'année derniere mais imo c'était ça)
   */
  @Override
  public boolean equals(Object o){
    if(o instanceof Film){
      Film filmAComparer = (Film) o;
      // String comparaison
      if(this.toString().equals(filmAComparer.toString())){
        return true;
      }
      return false;
    }
    return false;
  }

  public static void main(String[] args) {
    // String[] tab = {"a", "b", "c"};
    // Film f;
    // try{
    //   f = new Film("a", "a", tab, "a", 1800, 120);
    // }
    // catch (Exception e){
    //   System.out.println(e.getMessage);
    // }
    
    // Film filmGilbert = new Film("Dickson Greeting", "William Kennedy Laurie",
    //     1891, 2/60);

    Film f1 = new Film("Un singe en hiver", "Henri Verneuil");
    Film f2 = new Film("Un singe en hiver", "Henri Verneuil");
    Film f3 = new Film("oui", "non");
    if(f1.equals(f2)){
      System.out.println("f1 egal f2");
    }
    else{
      System.out.println("f1 pas egal f2");
    }
    System.out.println("Nombre d'objets Film: " + Film.compteur);

    // System.out.println(filmGilbert);
    
  }
}
