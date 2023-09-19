public class Question_4 {

  public static int sommePair(int[] tab){
    int somme = 0;
    for(int i = 0; i<tab.length; i++){
      if(tab[i]%2 == 0){
        somme+=tab[i];
      }
    }
    return somme;
  }

  public static void main(String[] args) {
    int tab[] = {8, 7, 12, 13, 15, 17, 20, 13, 5, 9};
    int somme = sommePair(tab);
    System.out.println(somme);
  }
}
