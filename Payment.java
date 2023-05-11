public class Payment {
    private String ID, payment_type = "cash";
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
    public String getPayment_type() {
        return payment_type;
    }
    public String getID() {
        return ID;
    }
    public Payment(String id){
        ID = id;
    }
    public void view(){
        System.out.println("ID:" + ID + "\nPayment type:Cash\n");
    }
}
