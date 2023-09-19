import java.util.Scanner;

/**
 * Main
 */
public class Main {

  static void genererTab(){
    int[] tab = new int[10];
    for(int i = 0; i<10; i++){
      tab[i] = i;
    }
    Scanner entree = new Scanner(System.in);
    System.out.println("Saisir un entier: ");
    int x = entree.nextInt();

    try{
      System.out.println("tab["+ x + "] = " + tab[x]);
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Mauvaise pioche!");
    }
  }

  public static void main(String[] args) {
    try {
      Date d1 = new Date(33, 10, 1885);
      Date d2 = new Date(9, 15, 2005);
      Date d3 = new Date(66, 30, 1966);
      Date d4 = new Date(31, 9, 2000); //septembre n'a que 30 jours.
      Date d5 = new Date(29, 2, 1000); //Fevrier n'a que 28 jours.
    } catch(JourException e){
      System.err.println("Erreur:");
      System.err.println(e.getMessage());
    } catch(MoisException e){
      System.err.println("Erreur:");
      System.err.println(e.getMessage());
    }
    catch (DateException e) {
      System.err.println("Erreur:");
      System.err.println(e.getMessage());
    }
  }
}
