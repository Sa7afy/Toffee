import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
/**
 * The type Toffee.
 */
public class Toffee {
    /**
     * The Catalog of the system.
     */
    Catalog catalog;
    /**
     * The Customers of the system.
     */
    Vector<customer> customers;
    /**
     * The Current customer which did log in.
     */
    customer curCustomer;

    /**
     * Instantiates a new Toffee system.
     */
    Toffee() {
        catalog = new Catalog();
        customers = new Vector<customer>();
        // NULL CUSTOMER
        curCustomer = new customer("1", "1", "1", "1");
    }

    /**
     * Read customers from the file.
     */
    void ReadCustomers() {
        try {
            File myObj = new File("src/main/java/customers.txt");
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
                }

                ind++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Read products of the store from the file.
     */
    void ReadProducts() {

        try {
            File myObj = new File("src/main/java/products.txt");
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

    /**
     * Login.
     */
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

    /**
     * Clearfile function.
     *
     * @param f the file name
     */
    public void clearfile(String f){
        try {
            FileWriter fileWriter = new FileWriter(f, false);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file.");
            e.printStackTrace();
        }
    }

    /**
     * Write to file.
     *
     * @param f the file name
     */
    public void write_to_file(String f){
        try {
            FileWriter fileWriter = new FileWriter(f);
            for(customer c: customers){
                fileWriter.write(c.ID+"\n");
                fileWriter.write(c.Email+"\n");
                fileWriter.write(c.phone+"\n");
                fileWriter.write(c.password+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    /**
     * Is valid egyptian phone number boolean.
     *
     * @param phoneNumber the phone number
     * @return the boolean
     */
    public boolean isValidEgyptianPhoneNumber(String phoneNumber) {
        // Egypt phone number regex pattern
        String regex = "^01[0-2]\\d{8}$";

        // Create a pattern object
        Pattern pattern = Pattern.compile(regex);

        // Match the input string with the pattern
        Matcher matcher = pattern.matcher(phoneNumber);

        // Return true if the phone number matches the pattern, false otherwise
        return matcher.matches();
    }

    /**
     * Is valid email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean isValidEmail(String email) {
        // Email regex pattern
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // Create a pattern object
        Pattern pattern = Pattern.compile(regex);

        // Match the input string with the pattern
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }

    /**
     * Register.
     */
    public void register() {
        String FullName = new String(), Email = new String(), PhoneNumber = new String(), Pw = new String();
        Scanner name = new Scanner(System.in);
        System.out.print("Full name:");
        FullName = name.nextLine();
        while (true) {
            Scanner email = new Scanner(System.in);
            System.out.print("Email:");
            Email = email.nextLine();
            if (isValidEmail(Email)) {
                System.out.println("Check your email ");
                String otp = SendOTP(Email);
                String input  = "";
                System.out.print("Enter OTP: ");
                input = email.nextLine();
                while (!Objects.equals(otp, input)) {
                    System.out.println("Try again ");
                    System.out.print("Enter OTP: ");
                    input = email.nextLine();
                }
                break;
            } else {
                int option;
                Scanner myObj = new Scanner(System.in);
                System.out.println("Wrong email format, click 1 to try again");
                option = myObj.nextInt();
                if (option != 1) {
                    System.out.println("Registration failed");
                    return;
                }
            }
        }
        while (true) {
            Scanner phone = new Scanner(System.in);
            System.out.print("Phone number:");
            PhoneNumber = phone.nextLine();
            if (isValidEgyptianPhoneNumber(PhoneNumber)) {
                break;
            } else {
                int option;
                Scanner myObj = new Scanner(System.in);
                System.out.println("Wrong phone number format, click 1 to try again");
                option = myObj.nextInt();
                if (option != 1) {
                    System.out.println("Registration failed");
                    return;
                }
            }
        }
        Scanner password = new Scanner(System.in);
        System.out.print("Password:");
        Pw = password.nextLine();

        customer c = new customer(FullName, Email, PhoneNumber, Pw);
        customers.add(c);
        int new_elem = customers.size()+1;
        System.out.println("Your ID is " + new_elem + ", You have to save it");
        System.out.println("registered successfully");
        String filename = "src/main/java/customers.txt";
        clearfile(filename);
        write_to_file(filename);
    }

    public String SendOTP(String Email) {

        GEmailSender gEmailSender = new GEmailSender();
        String from = "yaballa463@gmail.com";
        String subject = "Second: Sending email using GMail";
        String otp = OTPGenerator();
        String text = "Your OTP: " + otp;
        boolean b = gEmailSender.sendEmail(Email, from, subject, text);
        if (b) {
            System.out.println("Email is sent successfully to " + Email);
        } else {
            System.out.println("There is problem in sending email");
        }
        return otp;
    }

    public  String OTPGenerator(){
            Random random = new Random();
            StringBuilder otp = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                otp.append(random.nextInt(10));
            }
            return otp.toString();
    }

}

