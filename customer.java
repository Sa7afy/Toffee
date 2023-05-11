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

    public void setPayments(Vector<Payment> payments) {
        this.payments = payments;
    }

    

    void ShowData() {
        System.out.println("Name: " + this.FullName + " Email: " + this.Email + " Phone " + this.phone);
    }

}
