import java.util.Vector;
import java.util.*;

/**
 * The type Cart.
 */
public class cart {
    private Map<product, Integer> products;

    /**
     * Instantiates a new Cart.
     */
    public cart() {
        products = new HashMap<product, Integer>();
    }

    /**
     * Add.
     *
     * @param p        the product we want to add
     * @param quantity the quantity if item we want to add
     */
    public void add(product p, int quantity) {
        if (products.containsKey(p)) {
            products.put(p, products.get(p) + quantity);
        } else {
            products.put(p, quantity);
        }
    }

    /**
     * Remove an item from the cart with certain quantities
     *
     * @param p        the product we want to remove
     * @param quantity the quantity we want to remove of the product
     * @return the number of items will be removed
     */
    public int remove(product p, int quantity) {
        if (products.containsKey(p)) {
            int newQuantity = products.get(p) - quantity;
            if (newQuantity <= 0) {
                int will_be_added = products.get(p);
                products.remove(p);
                return will_be_added;
            } else {
                products.put(p, newQuantity);
                return quantity;
            }
        }
        else {
            System.out.println("You don't have this product in your cart");
            return 0;
        }
    }

    /**
     * Check if size = 0
     *
     * @return the boolean
     */
    public boolean empty(){
        return products.size() == 0;
    }

    /**
     * Calculate total cost of the cart.
     *
     * @return the cost
     */
    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getProductPrice() * entry.getValue();
        }
        return total;
    }

    /**
     * Clear all products in the cart.
     */
    public void clear() {products.clear();}

    /**
     * View all products in the cart.
     */
    public void view() {
        System.out.println("Cart:");
        for (Map.Entry<product, Integer> entry : products.entrySet()) {
            System.out.println("Product ID:" +entry.getKey().getProductID() + "  ||  " + entry.getKey().getProductName() + " x " + entry.getValue() + " @ $" + entry.getKey().getProductPrice() + " = $" + entry.getKey().getProductPrice() * entry.getValue());
        }
        System.out.println("Total: $" + calculateTotal());
    }

}



