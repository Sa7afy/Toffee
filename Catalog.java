import java.util.Objects;
import java.util.Vector;
public class Catalog {
    Vector<category> catalog;

    public Catalog(){
        catalog = new Vector<category>();
    }

    public void add(category Category){
        catalog.add(Category);
    }

    public void delete(category Category){
        catalog.remove(Category);
    }

    public void search_category(String id){
        for (int i = 0; i < catalog.size(); i++) {
            if(Objects.equals(catalog.elementAt(i).categoryID, id)){
                catalog.elementAt(i).view();
                return;
            }
        }
        System.out.println("Item not found");
    }

    public void search_product(String id){
        for (int i = 0; i < catalog.size(); i++) {
            for (int j = 0; j < catalog.elementAt(i).products.size(); j++) {
                if(Objects.equals(catalog.elementAt(i).products.elementAt(j), id)){
                    catalog.elementAt(i).products.elementAt(j).view();
                    return;
                }
            }
        }
        System.out.println("Item not found");
    }

    public void view(){
        for (category c : catalog) {
            for (product p : c.products) {
                p.view();
            }
        }
    }
}
