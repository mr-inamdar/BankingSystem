package bankingSystem.modules;

public class CurrentAccount extends Account {

    public CurrentAccount(long accountNumber,
                          String holderName,
                          double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void calculateIntrest() {
        System.out.println("Current account has no interest.");
    }
}