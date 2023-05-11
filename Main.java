import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Toffee toffee = new Toffee();
        toffee.ReadProducts();
        toffee.ReadCustomers();
        System.out.println("welcome To Toffee Store");
        System.out.println("Made by Yousef Abdalla Attia(20210475) and Mohand Magdy Ahmed(20210412) ");
        Scanner in = new Scanner(System.in);
        int option =  0;
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
        while (true){
            Scanner in2 = new Scanner(System.in);
            System.out.println("what do you want to do now...?");
            System.out.println("1-Browse catalog\n2-show Cart\n3-checkout cart\n4-exit");
            int op = in2.nextInt();
            if (op ==1){
                toffee.catalog.view();
                System.out.println("want add to cart? 1-YES 2-NO");
                int want = in2.nextInt();
                if(want ==1){
                    System.out.print("Enter Product ID: ");
                    int id = in2.nextInt();
                    product now = toffee.catalog.search(id);
                    if (now.ProductName!="NULL") {
                        System.out.print("Enter Amount: ");
                        int amount = in2.nextInt();
                        if (amount<=now.quantity){
                            toffee.curCustomer.mycart.add(now,amount);
                            now.quantity-=amount;
                            System.out.println("ADDED");
                        }
                        else {
                            System.out.println("This quantity not available");
                        }
                    }
                    else{
                        System.out.println("No such an ID");
                    }
                }
            }
            else if (op == 2){
                toffee.curCustomer.mycart.view();
            }
            else break;
        }
    }
}
