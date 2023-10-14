public class Main {

  public static void main(String[] args) {
    Agenda agenda = new Agenda("Nom", "Prenom", 2023);
    EvenementPonctuel e = new EvenementPonctuel(120, 10, 16, "Test", "Titre"); 
    EvenementRegulier e2 = new EvenementRegulier(10, 19, 23, "TestRegulier", "TitreRegulier", 250, 5);
    e.enregistreEvenement(agenda);
    System.out.println(e);
    System.out.println(e2);
    e2.enregistreEvenement(agenda);

    EvenementPonctuel e3 = new EvenementPonctuel(120, 16, 20, "aaa", "PtiteErreurOuuuuuu");
    e3.enregistreEvenement(agenda);

    System.out.println(agenda.toString());
  }
}
