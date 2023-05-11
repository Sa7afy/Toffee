import java.util.Objects;
import java.util.Vector;
public class Catalog {
    Vector<product> catalog;

    public Catalog(){
        catalog = new Vector<product>();
    }

    public void add(product prod){
        catalog.add(prod);
    }

    public void delete(product prod){
        catalog.remove(prod);
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
