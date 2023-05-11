public class product {
    int ProductID, quantity;
    double ProductPrice;
    static int productIdCount =0;
    String ProductName;

    product(String name, double price, int amount) {
        this.ProductID = ++productIdCount;
        this.ProductName = name;
        this.ProductPrice = price;
        this.quantity = amount;
    }

    public void setProductID(int id) {
        this.ProductID = id;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProductPrice(int productPrice) {
        ProductPrice = productPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return ProductID;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return ProductName;
    }

    void view(){
        System.out.println("ID: "+this.ProductID+" Name: "+ this.ProductName +" quantity: "+this.quantity + " Price: "+this.ProductPrice );
    }

}

