public class MoisException extends DateException {

 public MoisException(Object o, String msg){
    super(o, msg);
  } 

  public String toString(){
    return "Le mois est invalide!";
  }
}
