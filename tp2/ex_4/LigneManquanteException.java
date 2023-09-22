public class LigneManquanteException extends Exception{

 public LigneManquanteException(int ligne){
    super("La ligne " + ligne + " n'existe pas dans le fichier!");
  }
}
