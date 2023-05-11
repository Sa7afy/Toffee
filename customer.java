import javax.lang.model.type.NullType;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class customer extends user{
    static int IDCount = 0;
    Vector<Order> orders;
    cart mycart;
    customer(String Full_Name, String E_mail, String Phone,String Password) {
        this.FullName = Full_Name;
        this.Email = E_mail;
        this.phone = Phone;
        this.password = Password;
        this.ID = ++IDCount;
        orders = new Vector<Order>();
        mycart = new cart();
    }

    public Order check_out(){
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
            return order;
        }
        else{
            System.out.println("Your cart is empty.");
        }
        return null;
    }

    public void setMyCart(cart mycart) {
        this.mycart = mycart;
    }

    public cart getMycart() {
        return mycart;
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }

    public void add_order(Order order){
        this.orders.add(order);
    }

    public void delete(int orderID){
        for (int i = 0; i < orders.size(); i++) {
            if(Objects.equals(orders.elementAt(i).getID(), orderID)){
                orders.remove(orders.elementAt(i));
            }
        }
    }
    void Reorder(int orderID) {
        for (Order order : orders) {
            if (orderID == order.getID()) {
                boolean can;
            }
        }
        System.out.println("Order Not Found");
    }
    void getOrder(int orderID ) {
        for (Order order : orders) {
            if (orderID == order.getID()) {
                order.view();
                return;
            }
        }
        System.out.println("Order Not Found");
    }
    void ShowData() {
        System.out.println("ID: "+this.ID+"\nName: " + this.FullName + "\nEmail: " + this.Email + "\nPhone " + this.phone);
    }

}
