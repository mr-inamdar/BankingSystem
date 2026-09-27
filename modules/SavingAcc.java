package bankingSystem.modules;

public class SavingAcc extends Account{

    public SavingAcc(long accNumber, String name, double balence, long phone, String email, String address) {
        super(accNumber, name, balence, phone, email, address);
    }   

    @Override 
    public void calculateIntrest(){
        balence += balence * 0.04;
    }
}