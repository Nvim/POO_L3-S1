import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GestionFichier {

  String nomFichier;
  BufferedReader fichierTampon;
  int interdite;

  public GestionFichier(){
    Scanner s = new Scanner(System.in);

    while(true){
      System.out.println("Entrer un nom de fichier: ");
      nomFichier = s.nextLine();

      if(nomFichier.equals("STOP")) {
        System.exit(0);
      }

      try {
        fichierTampon = new BufferedReader(new FileReader(nomFichier));
        break;
      } catch (FileNotFoundException e) {
        System.err.println("Err: Le fichier a ouvrir n'existe pas!");
      }
    }

    Random random = new Random();
    interdite = random.nextInt(10) + 1;

    System.out.println("Fichier trouvé! Ligne interdite: " + interdite);
  }
  
  public void lire() throws Exception {
    Scanner input = new Scanner(System.in);
    String ligne = "default";

    System.out.println("Quelle ligne voulez-vous lire?: ");
    int numLigne = input.nextInt();
    System.out.println("Ligne choisie: " + numLigne);

    if(numLigne == interdite || numLigne < 1){
      throw new LigneInterditeException(numLigne);
    }

    try {
      int i = 1;
      while (i<numLigne && ligne != null){
        ligne = fichierTampon.readLine();
        i++;
      }
      ligne = fichierTampon.readLine();
      if(ligne == null){
        throw new LigneManquanteException(numLigne);
      }
      System.out.println("Contenu de la ligne " + numLigne + ": " + ligne);
    } catch (IOException e) {
      System.err.println("IOException");
    }
  }
}
