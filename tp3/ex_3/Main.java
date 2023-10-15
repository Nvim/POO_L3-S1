public class Main {

  public static void main(String[] args) {
    Agenda agenda = new Agenda("Nom", "Prenom", 2023);

    EvenementRegulier e2 = new EvenementRegulier(10, 19, 23, "TestRegulier", "TitreRegulier", 25, 5);
    System.out.println(e2);
    e2.enregistreEvenement(agenda);

    agenda.supprimeEvt(5);
    System.out.println("\n" + agenda.toString());
  }
}
