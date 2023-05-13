/**
 * The type Product.
 */
public class product {
    /**
     * The Product id.
     */
    int ProductID,
    /**
     * The Quantity of the product.
     */
    quantity;
    /**
     * The Product price.
     */
    double ProductPrice;
    /**
     * The Product id value which increments for any order assigned.
     */
    static int productIdCount =0;
    /**
     * The Product name.
     */
    String ProductName;

    /**
     * Instantiates a new Product.
     *
     * @param name   the name
     * @param price  the price
     * @param amount the amount
     */
    product(String name, double price, int amount) {
        this.ProductID = ++productIdCount;
        this.ProductName = name;
        this.ProductPrice = price;
        this.quantity = amount;
    }

    /**
     * Sets product id.
     *
     * @param id the id
     */
    public void setProductID(int id) {
        this.ProductID = id;
    }

    /**
     * Sets product name.
     *
     * @param productName the product name
     */
    public void setProductName(String productName) {
        ProductName = productName;
    }

    /**
     * Sets product price.
     *
     * @param productPrice the product price
     */
    public void setProductPrice(int productPrice) {
        ProductPrice = productPrice;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public int getProductID() {
        return ProductID;
    }

    /**
     * Gets product price.
     *
     * @return the product price
     */
    public double getProductPrice() {
        return ProductPrice;
    }

    /**
     * Gets quantity of product.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * View all product details.
     */
    void view(){
        System.out.println("ID: "+this.ProductID+" Name: "+ this.ProductName +" quantity: "+this.quantity + " Price: "+this.ProductPrice );
    }

}


