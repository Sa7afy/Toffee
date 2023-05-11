import java.util.Vector;

public class customer extends user{
    static int IDCount = 0;
    Vector<Payment>payments;
    Vector<Order> orders;
    cart mycart;
    customer(String Full_Name, String E_mail, String Phone,String Password) {
        this.FullName = Full_Name;
        this.Email = E_mail;
        this.phone = Phone;
        this.password = Password;
        this.ID = ++IDCount;
        payments = new Vector<Payment>();
        orders = new Vector<Order>();
        mycart = new cart();
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

    public Vector<Payment> getPayments() {
        return payments;
    }

    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }
    
    public void add_order(Order order){
        this.orders.add(order);
    }

    public void delete(String orderID){
        for (int i = 0; i < orders.size(); i++) {
            if(Objects.equals(orders.elementAt(i).getID(), orderID)){
                orders.remove(orders.elementAt(i));
            }
        }
    }

    public void setPayments(Vector<Payment> payments) {
        this.payments = payments;
    }

    void Reorder(String orderID) {
        for (Order order : orders) {
            if (orderID == order.getID()) {
                orders.add(order);
                System.out.println(" reorder " + orderID + " is Done");
                return;
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
        System.out.println("Name:" + this.FullName + "\nEmail:" + this.Email + "\nPhone:" + this.phone);
    }


}
