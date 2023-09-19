public class Question_5 {

  public static int[] echanger(int[] tab, int i, int j){
    if (i < 0 || i > tab.length || j < 0 || j > tab.length){
      System.out.println("Erreur, les valeurs de i et j ne sont pas valides.");
      return tab;
    }
    int tmp = tab[i];
    tab[i] = tab[j];
    tab[j] = tmp;
    return tab;
  }

  public static void main(String[] args) {
    int[] tab = {44, 5, 12, 22};
    tab = echanger(tab, 0, 3);
    for(int i = 0; i<tab.length; i++){
      System.out.println(tab[i]);
    }
  }
}
