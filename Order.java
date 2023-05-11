public class Order {
    private static int order_ID = 0;
    private int ID;
    private double price;
    private String order_status = "Shipping", address;
    public cart order_details;

    public Order(cart crt, String Address) {
        ID = ++order_ID;
        order_details = crt;
        price = order_details.calculateTotal();
        address = Address;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void update(cart crt) {
        order_details = crt;
        price = order_details.calculateTotal();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public String getOrder_status() {
        return order_status;
    }

    public int getID() {
        return ID;
    }

    public void view() {
        System.out.println("OrderID:" + ID );
        order_details.view();
    }
}
