package bankingSystem.modules;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public  long accNumber;
    public  String name;
    protected double balence;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(long accNumber, String name, double balence){
        this.accNumber = accNumber;
        this.name = name;
        this.balence = balence;
    }

    public abstract void calculateIntrest();

    public String withdraw(double ammount){
        if (ammount <= 0) {
            return "Invalid amount";
        }

        if (balence < ammount) {
            return "Ineficient balence";
        }

        balence -= ammount;
        return "Current balence: " + balence;
    }

    public String deposit(double ammount){
        if (ammount <= 0) {
            return "Invalid amount";
        }

        balence += ammount;
        return "Current balence: " + balence;
    }

    public double checkBalence(){
        return balence;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
