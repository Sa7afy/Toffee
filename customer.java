public class customer extends user{
    static int IDCount = 0;

    customer(String Full_Name, String E_mail, String Phone,String Password) {
        this.FullName = Full_Name;
        this.Email = E_mail;
        this.phone = Phone;
        this.password = Password;
        this.ID = ++IDCount;
    }

    void ShowData() {
        System.out.println("Name: " + this.FullName + " Email: " + this.Email + " Phone " + this.phone);
    }

}
