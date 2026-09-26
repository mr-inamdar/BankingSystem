package bankingSystem.modules;

public class SavingAcc extends Account{

    public SavingAcc(long accNumber, String name, double balence) {
        super(accNumber, name, balence);
    }   

    @Override 
    public void calculateIntrest(){
        balence += balence * 0.04;
    }
}