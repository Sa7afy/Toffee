public class Order {
    private static int order_ID = 0;
    private int ID;
    private double price;
    private int order_status = 2, paid = 1, late = 0, pending = 2;

    public cart order_details;

    public Order(cart crt) {
        ID = ++order_ID;
        order_details = crt;
        price = order_details.calculateTotal();
    }
    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
    public void update(cart crt) {
        order_details = crt;
        price = order_details.calculateTotal();
    }

    public double getPrice() {
        return price;
    }

    public int getOrder_status() {
        return order_status;
    }

    public int getID() {
        return ID;
    }

    public void view() {
        System.out.println("ID:" + ID + "\nPrice:" + price + "\n");
        if (order_status == pending) {
            System.out.println("Order status:pending");
        }
        else if (order_status == late) {
            System.out.println("Order status:Late");
        } else {
            System.out.println("Order status:Paid & shipped");
        }
        order_details.view();
    }
}
