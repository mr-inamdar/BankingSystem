package bankingSystem.modules;

public class Costamer {
    protected  long phone;
    protected  String email;
    protected  String address;

    public Costamer(long phone, String email, String address){
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void displayInfo(){
        System.out.println("Phone number: " + this.phone);
        System.out.println("Email: " + this.email);
        System.out.println("Address: " + this.address);
    }

    public void updatePhone(long phone){
        this.phone = phone;
        System.out.println("Now Phone number: " + this.phone);
    }

    public void updateEmail(String emial){
        this.email = emial;
        System.out.println("Now Email: " + this.email);
    }

    public void updateAddress(String address){
        this.address = address;
        System.out.println("Now Address: " + this.address);
    }
}
