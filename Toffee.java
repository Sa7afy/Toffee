import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Objects;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;

public class Toffee {
    Catalog catalog;
    Vector<customer> customers;
    customer curCustomer;

    Toffee() {
        catalog = new Catalog();
        customers = new Vector<customer>();
        // NULL CUSTOMER
        curCustomer = new customer("1", "1", "1", "1");
    }

    void ReadCustomers() {
        try {
            File myObj = new File("src/customers.txt");
            Scanner myReader = new Scanner(myObj);
            int ind = 1;
            String name = new String(), email = new String(), phone = new String(), pass = new String();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (ind % 4 == 1) {
                    name = data;
                } else if (ind % 4 == 2) {
                    email = data;
                } else if (ind % 4 == 3) {
                    phone = data;
                } else {
                    pass = data;
                    customer cus = new customer(name, email, phone, pass);
                    customers.add(cus);
                    cus.ShowData();
                }

                ind++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void ReadProducts() {

        try {
            File myObj = new File("src/products.txt");
            Scanner myReader = new Scanner(myObj);
            int ind = 1;
            String name = new String(), price = new String(), amount = new String();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (ind % 3 == 1) {
                    name = data;
                } else if (ind % 3 == 2) {
                    price = data;
                } else {
                    amount = data;
                    product pr = new product(name, Double.parseDouble(price), Integer.parseInt(amount));
                    catalog.add(pr);
                }
                ind++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void login() {
        Scanner myObj = new Scanner(System.in);
        int ID, option;

        boolean found = false;
        while (!found) {
            System.out.print("Enter your ID:");
            ID = myObj.nextInt();
            for (customer c : customers) {
                if (c.ID == ID) {
                    boolean pass = false;
                    while (!pass) {
                        Scanner k = new Scanner(System.in);
                        System.out.print("Enter your password: ");
                        String password = k.nextLine();
                        if (Objects.equals(password, c.password)) {
                            System.out.println("LOGIN success");
                            pass = true;
                            found = true;
                            curCustomer = c;
                        } else {
                            System.out.println("Your password is wrong Enter 1 to try again else for edit ID");
                            option = myObj.nextInt();
                            if (option != 1) {
                                break;
                            }
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("NO such a ID To edit ID enter 1 anything else to get out");
                option = myObj.nextInt();
                if (option != 1) {
                    break;
                }
            }
        }
    }
}


