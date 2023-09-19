public class Question_3 {

  public static void afficherTab(int[] tab){
    for(int i = 0; i<tab.length; i++){
      System.out.println("tab[" + i + "] = " + tab[i]);
    }
  }

  public static void main(String[] args) {
    int[] tab = new int[5];
    for(int i = 0; i<tab.length; i++){
      tab[i] = i;
    }
    afficherTab(tab);
  }
}
