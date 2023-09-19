public class Bonus {
  public static int[] maximum(int[] tab){
    int max = -2147000000;
    int index = 0;
    for(int i = 0; i<tab.length; i++){
      if(tab[i]>max){
        max = tab[i];
        index = i;
      }
    }
    int[] res = new int[2];
    res[0] = max;
    res[1] = index;
    return res;
  }

  public static int compteSup(int[] tab, int v){
    int count = 0;
    for(int i = 0; i<tab.length; i++){
      if(tab[i] >= v){
        count++;
      }
    }
    return count;
  }

  public static int rechercher(int[] tab, int v){
    for(int i = 0; i<tab.length; i++){
      if(tab[i] == v){
        return i;
      }
    }
    return -1;
  }

  public static boolean estTrie(int[] tab){
    for(int i = 1; i < tab.length; i++){
      if(tab[i] < tab[i-1]){
        return false;
      }
    }
    return true;
  }

  static int[] fusion(int[] tab1, int[] tab2){
    int size = tab1.length+tab2.length;
    int[] res = new int[size];
    int i = 0, j = 0;

    while(i<tab1.length){
      res[i] = tab1[i];
      i++;
    }
    // i = tab1.length
    while(j<tab2.length){
      res[i] = tab2[j];
      i++;
      j++;
    }
    return res;
  }

  public static void main(String[] args) {
    int[] t1 = {44, 38, 29, 16, 39};
    int[] t2 = {22, 17, 18, -5, 16};
    int[] t = fusion(t1, t2); 

    for(int i = 0; i<t.length; i++){
      System.out.println("tab[" + i + "] = " + t[i]);
    }
  }
}
