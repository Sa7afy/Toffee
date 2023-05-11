/**
 * The type Order.
 */
public class Order {
    private static int order_ID = 0;
    private int ID;
    private double price;
    private String address;
    /**
     * The Order details (all items in order).
     */
    public cart order_details;

    /**
     * Instantiates a new Order.
     *
     * @param crt     the cart
     * @param Address the address of the customer
     */
    public Order(cart crt, String Address) {
        ID = ++order_ID;
        order_details = crt;
        price = order_details.calculateTotal();
        address = Address;
    }

    /**
     * Update an order.
     *
     * @param crt the cart
     */
    public void update(cart crt) {
        order_details = crt;
        price = order_details.calculateTotal();
    }

    /**
     * Gets address of the customer who did the order.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address of the customer.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets price of the order.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets id of the order.
     *
     * @return the id
     */
    public int getID() {
        return ID;
    }

    /**
     * View all order details.
     */
    public void view() {
        System.out.println("OrderID:" + ID );
        order_details.view();
    }
}
