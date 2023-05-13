import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

/**
 * The type Catalog.
 */
public class Catalog {
    /**
     * The Catalog carries all products.
     */
    Vector<product> catalog;

    /**
     * Instantiates a new Catalog.
     */
    public Catalog() {
        catalog = new Vector<product>();
    }

    /**
     * Add product to catalog.
     *
     * @param p the product we want to add
     */
    public void add(product p) {
        catalog.add(p);
    }

    /**
     * Delete product from the catalog.
     *
     * @param p the p
     */
    public void delete(product p) {
        catalog.remove(p);
    }

    /**
     * Search for a product in the catalog.
     *
     * @param id the id of the product
     * @return the product
     */
    public product search(int id) {
        for (int i = 0; i < catalog.size(); i++) {
            if (Objects.equals(catalog.elementAt(i).ProductID, id)) {
                return catalog.elementAt(i);
            }
        }
        System.out.println("Item not found");
        return new product("NULL", 0, 0);
    }

    /**
     * function that clears the file to write again.
     *
     * @param filename the filename
     */
    public void clearfile(String filename){
        try {
            FileWriter fileWriter = new FileWriter(filename, false);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file.");
            e.printStackTrace();
        }
    }

    /**
     * Write to file.
     *
     * @param filename the filename
     */
    public void write_to_file(String filename){
        try {
            FileWriter fileWriter = new FileWriter(filename);
            for(product p : catalog){
                fileWriter.write(p.ProductName+"\n");
                fileWriter.write(p.ProductPrice+"\n");
                fileWriter.write(p.quantity+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    /**
     * View all catalog.
     */
    public void view() {
        for (product p : catalog) {
            p.view();
        }

    }
}
