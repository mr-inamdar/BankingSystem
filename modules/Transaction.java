package bankingSystem.modules;

public class Transaction {

    private String type;
    private double amount;
    private double balanceAfter;
    private String date;
    private int transactionId;

    public Transaction(String type, double amount, double balanceAfter,
                       String date, int transactionId) {

        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.date = date;
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public String getDate() {
        return date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                "\nType: " + type +
                "\nAmount: ₹" + amount +
                "\nBalance After: ₹" + balanceAfter +
                "\nDate: " + date;
    }
}