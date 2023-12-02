package tp5.util;

import tp5.exception.CalculatriceException;

public class Calculatrice {

  static int nbOperations;

  public static int addition(int a, int b){
    return a+b;
  }

  public static int soustraction(int a, int b){
    return a-b;
  }

  public static int multiplication(int a, int b){
    return a*b;
  }

  public static int division(int a, int b) throws CalculatriceException{
    if(b == 0){
      throw new CalculatriceException("\nErreur, division par 0!");
    }
    return a/b;
  }
  
}
