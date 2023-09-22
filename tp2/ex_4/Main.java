public class Main {

  public static void main(String[] args) {
    GestionFichier f = new GestionFichier();
    try {
      f.lire();
    }catch(LigneManquanteException e){
      System.err.println("**** Exception Ligne manquante trouvée: ");
      System.err.println(e.getMessage());
    }catch(LigneInterditeException e){
      System.err.println("**** Exception Ligne interdite trouvée: ");
      System.err.println(e.getMessage());
    }
    catch (Exception e) {
      System.out.println("**** Exception classqique trouvée: ");
      System.err.println(e.getMessage());
    }
  }
}
