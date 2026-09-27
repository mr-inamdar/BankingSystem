package bankingSystem;

import java.util.Scanner;

import bankingSystem.modules.Account;
import bankingSystem.modules.CurrentAccount;
import bankingSystem.modules.SavingAcc;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while(true){
            System.out.println("1. Create Account\n 2. Deposit\n 3. Withdraw\n 4. Check Balance\n 5. Transfer\n 6. Transaction History\n 7. Display Informetion\n 8. Edit Informetion\n 9. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter your name: s");
                String name = sc.nextLine();
                System.out.print("Enter your email: s");
                String email = sc.nextLine();
                System.out.print("Enter your address: s");
                String address = sc.nextLine();
                System.out.print("Enter your phone number: s");
                long phone = sc.nextLong();
                double balence = 0;
                long accNumber = bank.generateAccountNumber();

                System.out.println("Your account number is : " + accNumber);

                System.out.print("You want to deposit some belence y/n: ");
                String yn = sc.nextLine();

                if (yn == "y") {
                    System.out.print("Enter ammount: ");
                    balence = sc.nextDouble();
                }

                System.out.println("1. saving account\n 2. Current account");
                System.out.print("Enter your choice : ");
                int typ = sc.nextInt();

                if (typ == 1) {
                    SavingAcc acc = new SavingAcc(accNumber, name, balence, phone, email, address);
                    bank.addAccount(acc);
                }
                else if (typ == 2) {
                    CurrentAccount acc = new CurrentAccount(accNumber, name, balence, phone, email, address);
                    bank.addAccount(acc);
                }
                else{
                    System.out.println("Enter the correct choice");
                }  
            }    
            else if (choice == 2) {
                System.out.print("Enter your account number: ");
                long accNumber = sc.nextLong();
                System.out.print("Enter ammount that you want to deposite: ");
                double ammount = sc.nextDouble();

                bank.deposit(accNumber, ammount);
            }
            else if (choice == 3) {
                System.out.print("Enter your account number: ");
                long accNumber = sc.nextLong();
                System.out.print("Enter ammount that you want to widhraw: ");
                double ammount = sc.nextDouble();

                bank.withdraw(accNumber, ammount);
            }
            else if (choice == 4) {
                System.out.print("Enter your account number: ");
                long accNumber = sc.nextLong();

                bank.getMybelence(accNumber)
            }
            else if (choice == 5) {
                System.out.print("Enter your account number from transfer: ");
                long accNumberFrom = sc.nextLong();
                System.out.print("Enter your account number to transfer: ");
                long accNumberTo = sc.nextLong();
                System.out.print("Enter ammount that you want to transfer: ");
                double ammount = sc.nextDouble();

                bank.transfer(accNumberFrom, accNumberTo, ammount);
            }
            else if (choice == 6) {
                System.out.print("Enter your account number: ");
                long accNumber = sc.nextLong();

                Account acc = bank.findAccount(accNumber);
                System.out.println("Your Transaction hestory: " + acc.getTransactions());
            }
            else if (choice == 7) {
                System.out.print("Enter your account number: ");
                long accNumber = sc.nextLong();

                Account acc = bank.findAccount(accNumber);
                System.out.println("Your current informetion: ");
                acc.c.displayInfo();
            }
            else if (choice == 8) {
                System.out.print("Enter your account number: ");
                long accNumber = sc.nextLong();

                Account acc = bank.findAccount(accNumber);
                System.out.println("1. Edit Phone Number\n 2. Edit Email Address\n 3. Edit Address: ");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter New Phone Number: ");
                        long nPhone = sc.nextLong();

                        acc.c.updatePhone(nPhone);
                        break;
                    case 2:
                        System.out.print("Enter New Email: ");
                        String nEmail = sc.nextLine();

                        acc.c.updateEmail(nEmail);
                        break;
                    case 3:
                        System.out.print("Enter New Address: ");
                        String nAddress = sc.nextLine();

                        acc.c.updateAddress(nAddress);
                        break;
                    default:
                        System.out.print("Enter correct one");
                        break;
                }
                
            }
            else if (choice == 9) {
                System.out.println("Exiting....");
                break;
            }
            else{
                System.out.println("Enter correct choice");
            }        
        }

        sc.close();
    }
}
