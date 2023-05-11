import javax.lang.model.type.NullType;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

/**
 * The type Customer.
 */
public class customer extends user{
    /**
     * The id that increments and assigned for every new customer.
     */
    static int IDCount = 0;
    /**
     * The Orders of the customer.
     */
    Vector<Order> orders;
    /**
     * The cart of the customer.
     */
    cart mycart;

    /**
     * Instantiates a new Customer.
     *
     * @param Full_Name the full name
     * @param E_mail    the e mail
     * @param Phone     the phone
     * @param Password  the password
     */
    customer(String Full_Name, String E_mail, String Phone,String Password) {
        this.FullName = Full_Name;
        this.Email = E_mail;
        this.phone = Phone;
        this.password = Password;
        this.ID = ++IDCount;
        orders = new Vector<Order>();
        mycart = new cart();
    }

    /**
     * Check out order and add it to the customer's orders.
     *
     */
    public void check_out(){
        if(!mycart.empty()) {
            System.out.print("Please enter your address:");
            Scanner add = new Scanner(System.in);
            String address;
            address = add.nextLine();
            Order order = new Order(mycart, address);
            orders.add(order);
            System.out.println("Items are being shipped & will arrive as soon as possible");
            order.view();
            mycart.clear();
        }
        else{
            System.out.println("Your cart is empty.");
        }
    }

    /**
     * Sets my cart to a new one.
     *
     * @param mycart customer's cart
     */
    public void setMyCart(cart mycart) {
        this.mycart = mycart;
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public cart getMycart() {
        return mycart;
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public Vector<Order> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }

    /**
     * Add order to customer's orders.
     *
     * @param order the order
     */
    public void add_order(Order order){
        this.orders.add(order);
    }

    /**
     * Gets an order.
     *
     * @param orderID the order id
     */
    void getOrder(int orderID ) {
        for (Order order : orders) {
            if (orderID == order.getID()) {
                order.view();
                return;
            }
        }
        System.out.println("Order Not Found");
    }

    /**
     * Show all customer's orders.
     */
    void ShowData() {
        System.out.println("ID: "+this.ID+"\nName: " + this.FullName + "\nEmail: " + this.Email + "\nPhone " + this.phone);
    }

}

