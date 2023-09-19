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
    entree.close();

    try{
      System.out.println("tab["+ x + "] = " + tab[x]);
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Mauvaise pioche!");
    }
  }

  public static void main(String[] args) {
    Message m = new Message();
    m.contient("toto");
  }
}
