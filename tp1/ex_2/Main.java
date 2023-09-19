import java.util.Scanner;
// Fichier Main.java
public class Main {

  // retounre un tableau de n entiers contenant des valeurs
  // saisies par l'utilisateur
  public static int[] saisieTableau(int n){
    
    Scanner entree = new Scanner(System.in);
    int[] tab = new int[n];

    for(int i = 0; i<n; i++){
      System.out.println("Saisir un nombre:");
      tab[i] = entree.nextInt();
    }
    entree.close();
    return tab;
  }


  public static void main(String[] args) {

    int taille = 6;
    int[] tab = saisieTableau(taille);

    System.out.println("**AFFICHAGE**");
    System.out.println("Taille du tableau: " + tab.length);

    for(int i = 0; i<taille; i++){
      System.out.println("tab[" + i + "] = " + tab[i]);
    }
  }
}
