public class Main {

  public static void main(String[] args) {
    Compte courant = new Courant("Naim", 1000000);
    Compte remunere = new Remunere("remunuere", 3, 2222);

    System.out.println(courant);
    System.out.println(remunere);

    Agence agence = new Agence("agenceez");
    agence.ajouter(courant);
    agence.ajouter(remunere);

    System.out.println(agence);
  }
}
