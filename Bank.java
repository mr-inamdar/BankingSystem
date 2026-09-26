package bankingSystem;

import java.util.*;

import bankingSystem.modules.Account;
import bankingSystem.modules.Transaction;

public class Bank {

    private Map<Long, Account> accounts = new HashMap<>();

    private Set<Integer> transactionIds = new HashSet<>();

    public long generateAccountNumber() {

        Random random = new Random();

        long accountNumber;

        do {
            accountNumber = 100000000000L
                    + random.nextLong(900000000000L);

        } while (accounts.containsKey(accountNumber));

        return accountNumber;
    }

    public int generateTransactionId() {

        Random random = new Random();

        int transactionId;

        do {
            transactionId = random.nextInt(9000) + 1000;

        } while (transactionIds.contains(transactionId));

        transactionIds.add(transactionId);

        return transactionId;
    }

    public void addAccount(Account account) {

        accounts.put(account.accNumber, account);
    }

    public Account findAccount(long accountNumber) {

        return accounts.get(accountNumber);
    }


    public void deposit(long accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        account.deposit(amount);

        int transactionId = generateTransactionId();

        Transaction transaction = new Transaction(
                "DEPOSIT",
                amount,
                account.checkBalence(),
                new Date().toString(),
                transactionId
        );

        account.addTransaction(transaction);
    }

    public void withdraw(long accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        account.withdraw(amount);

        int transactionId = generateTransactionId();

        Transaction transaction = new Transaction(
                "WITHDRAW",
                amount,
                account.checkBalence(),
                new Date().toString(),
                transactionId
        );

        account.addTransaction(transaction);
    }

    public void transfer(long fromAccountNumber,
                         long toAccountNumber,
                         double amount) {

        Account sender = findAccount(fromAccountNumber);
        Account receiver = findAccount(toAccountNumber);

        if (sender == null) {
            System.out.println("Sender account not found");
            return;
        }

        if (receiver == null) {
            System.out.println("Receiver account not found");
            return;
        }

        if (sender.checkBalence() < amount) {
            System.out.println("Insufficient balance");
            return;
        }


        sender.withdraw(amount);
        receiver.deposit(amount);

        int senderTransactionId = generateTransactionId();

        Transaction senderTransaction = new Transaction(
                "TRANSFER OUT",
                amount,
                sender.checkBalence(),
                new Date().toString(),
                senderTransactionId
        );

        sender.addTransaction(senderTransaction);

        int receiverTransactionId = generateTransactionId();

        Transaction receiverTransaction = new Transaction(
                "TRANSFER IN",
                amount,
                receiver.checkBalence(),
                new Date().toString(),
                receiverTransactionId
        );

        receiver.addTransaction(receiverTransaction);


        System.out.println("Transfer successful!");
    }
}