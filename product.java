public class product {
    int ProductID, ProductPrice, quantity;

    String ProductName;

    product(int id, String name, int price, int amount) {
        this.ProductID = id;
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

    public int getProductPrice() {
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
