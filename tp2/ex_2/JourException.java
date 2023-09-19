public class JourException extends DateException {

  public JourException(Object o, String msg){
    super(o, msg);
  } 

  public String toString(){
    return "Le jour est invalide!";
  }
}
