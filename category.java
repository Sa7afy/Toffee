import java.util.Vector;
public class category {
    String categoryName;
    Vector<product> products;
    int categoryID;

    category(int id, String name) {
        this.categoryID = id;
        this.categoryName = name;
    }


    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    String getName() {
        return this.categoryName;
    }

    int getID() {
        return this.categoryID;
    }

    void addProduct(product p) {
        products.add(p);
    }

    void deleteProduct(product p) {
        products.remove(p);
    }

    void view() {
        for (product p : products) {
            p.view();
        }
    }
}
