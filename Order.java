public class Order {
    private String ID;
    private double price;
    private int order_status = 2, paid = 1, late = 0, pending = 2;

    public Order(String ID, double price) {
        this.ID = ID;
        this.price = price;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getOrder_status() {
        return order_status;
    }

    public String getID() {
        return ID;
    }

    public void view() {
        System.out.println("ID:" + ID + "\nPrice:" + price + "\n");
        if (order_status == pending) {
            System.out.println("Order status:pending\n");
        }
        else if (order_status == late) {
            System.out.println("Order status:Late\n");
        } else {
            System.out.println("Order status:Paid & shipped\n");
        }
    }
}
