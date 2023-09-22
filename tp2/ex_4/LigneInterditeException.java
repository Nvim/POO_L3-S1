public class LigneInterditeException extends Exception{

  public LigneInterditeException(int ligne){
    super("La ligne " + ligne + " est interdite en lecture !");
  }
  
}
