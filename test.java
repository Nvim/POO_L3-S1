public class test{

  // retourne un tableau de n entiers rempli de dizaines
  public static int[] initTab(int n){
    int[] tab = new int[n];

    for (int i = 0; i < n; i++){
      tab[i] = i+(i*10)-1;
    }
    return tab;
  }

  public static void main(String[] args) {
    int[] tab = initTab(4);
    System.out.println(tab[4]);
  }
}
