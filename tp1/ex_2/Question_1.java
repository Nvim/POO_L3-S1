public class Question_1 {

  // retourne un tableau de n entiers rempli de dizaines
  public static int[] initTab(int n){
    int[] tab = new int[n];

    for (int i = 0; i < n; i++){
      tab[i] = i*10;
      // System.out.println("i = " + i + ", i*10= " + i*10);
    }
    return tab;
  }

  public static void main(String[] args) {
    int[] tab = initTab(4);
    for(int i = 0; i<4; i++){
      System.out.println(tab[i]);
    }
  }
}
