import java.util.Vector;
import java.util.*;
public class cart {
    private Map<product, Integer> products;

    public cart() {
        products = new HashMap<product, Integer>();
    }

    public void add(product p, int quantity) {
        if (products.containsKey(p)) {
            products.put(p, products.get(p) + quantity);
        } else {
            products.put(p, quantity);
        }
    }

    public void remove(product product, int quantity) {
        if (products.containsKey(product)) {
            int newQuantity = products.get(product) - quantity;
            if (newQuantity <= 0) {
                products.remove(product);
            } else {
                products.put(product, newQuantity);
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getProductPrice() * entry.getValue();
        }
        return total;
    }


    public void print() {
        System.out.println("Cart:");
        for (Map.Entry<product, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey().getProductName() + " x " + entry.getValue() + " @ $" + entry.getKey().getProductPrice() + " = $" + entry.getKey().getProductPrice() * entry.getValue());
        }
        System.out.println("Total: $" + calculateTotal());
    }


    public void view(){

    }
}
