import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Toffee toffee = new Toffee();
        toffee.ReadProducts();
        toffee.ReadCustomers();
        System.out.println("welcome To Toffee Store");
        System.out.println("Made by Yousef Abdalla Attia(20210475) and Mohand Magdy Ahmed(20210412) ");
        Scanner in = new Scanner(System.in);
        int option = 0;
        while (toffee.curCustomer.ID == 1) {
            System.out.println("what you want to do now...?");
            System.out.println("1-Login\n2-register\n3-Browse catalog\n4-Exit");
            option = in.nextInt();
            if (option == 1) {
                toffee.login();
            } else if (option == 2) {
                toffee.register();
            } else if (option == 3) {
                toffee.catalog.view();
            } else {
                System.out.println("Thanks for using our Store");
                return;
            }
        }
        while (true) {
            Scanner in2 = new Scanner(System.in);
            System.out.println("what do you want to do now...?");
            System.out.println("""
                    1-Browse catalog
                    2-show Cart
                    3-checkout cart
                    4-clear cart
                    5-Remove item from the cart
                    6-exit""");
            int op = in2.nextInt();
            if (op == 1) {
                toffee.catalog.view();
                System.out.println("want add to cart? 1-YES 2-NO");
                int want = in2.nextInt();
                if (want == 1) {
                    System.out.print("Enter Product ID: ");
                    int id = in2.nextInt();
                    product now = toffee.catalog.search(id);
                    if (Objects.equals(now.ProductName, "NULL")) {
                        System.out.print("Enter Amount: ");
                        int amount = in2.nextInt();
                        if (amount <= now.quantity) {
                            toffee.curCustomer.mycart.add(now, amount);
                            now.quantity -= amount;
                            System.out.println("ADDED");
                        } else {
                            System.out.println("This quantity not available");
                        }
                    } else {
                        System.out.println("No such an ID");
                    }
                }
            } else if (op == 2) {
                toffee.curCustomer.mycart.view();
            } else if (op == 3) {
                if (Objects.equals(toffee.curCustomer.Email, "1")) {
                    System.out.println("You must be logged in.");
                } else {
                    toffee.curCustomer.check_out();
                }
            } else if (op == 4) {
                toffee.curCustomer.mycart.clear();
            } else if (op == 5) {
                toffee.curCustomer.mycart.view();
                System.out.println("This is your items in the cart\n" +
                        "Please enter ID and quantity of item you want to delete");
                product prod;
                int ID, quantity;
                Scanner idd = new Scanner(System.in);
                System.out.print("ID:");
                ID = idd.nextInt();
                System.out.print("Quantity:");
                Scanner quant = new Scanner(System.in);
                quantity = quant.nextInt();
                prod = toffee.catalog.search(ID);
                int removed = toffee.curCustomer.mycart.remove(prod, quantity);
                prod.quantity += removed;
            } else break;
        }
    }
}



