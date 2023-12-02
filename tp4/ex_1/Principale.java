import java.util.List;

public class Principale {

  public static void main(String[] args) {
    // Color vert = new Color(0, 255, 0);
    // Color rouge = new Color(255, 0, 0);
    // try {
    //   Jedi jedi1 = new Jedi("jedi1", 360, 0, 0, 10, "vert");    
    //   Jedi jedi2 = new Jedi("jedi2", 1000, 0, 0, 100, "rouge");    
    //   SoldatClone clone1 = new SoldatClone("clone1", 0, 0);
    //
    //
    //
    //   jedi1.allumerArme();
    //   jedi2.allumerArme();
    //
    //   while(true){
    //     jedi1.coupSabre(jedi2);
    //     jedi2.coupSabre(jedi1);
    //   }
    //
    // } catch (MortException e) {
    //   System.err.println(e.getMessage());
    // }
    List<Jedi> listJedi = Jedi.genererListJedi(20);

    // suppression d'un élément de la liste si son index est pair

    // affichage de la liste
    // listJedi.forEach(e -> System.out.println(e));

    List<Jedi> listeTriee = Jedi.trier(listJedi);
    listeTriee.forEach(e -> System.out.println(e));
  }
}
