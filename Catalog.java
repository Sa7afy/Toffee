import java.util.Objects;
import java.util.Vector;
public class Catalog {
    Vector<product> catalog;

    public Catalog(){
        catalog = new Vector<product>();
    }

    public void add(product p){
        catalog.add(p);
    }

    public void delete(product p){
        catalog.remove(p);
    }

    public void search(String id){
        for (int i = 0; i < catalog.size(); i++) {
            if(Objects.equals(catalog.elementAt(i).ProductID, id)){
                catalog.elementAt(i).view();
                return;
            }
        }
        System.out.println("Item not found");
    }
    public void view(){
            for (product p : catalog) {
                p.view();
            }
        
    }
}
