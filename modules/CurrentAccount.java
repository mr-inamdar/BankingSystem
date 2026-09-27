package bankingSystem.modules;

public class CurrentAccount extends Account {

    public CurrentAccount(long accountNumber, String holderName, double balance, long phone, String email, String address) {
        super(accountNumber, holderName, balance, phone, email, address);
    }

    @Override
    public void calculateIntrest() {
        System.out.println("Current account has no interest.");
    }
}