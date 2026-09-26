package bankingSystem;

import java.util.Scanner;

import bankingSystem.modules.CurrentAccount;
import bankingSystem.modules.SavingAcc;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while(true){
            System.out.println("1. Create Account\n 2. Deposit\n 3. Withdraw\n 4. Check Balance\n 5. Transfer\n 6. Transaction History\n 7. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter your name: s");
                String name = sc.nextLine();
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
                    SavingAcc acc = new SavingAcc(accNumber, name, balence);
                    bank.addAccount(acc);
                }
                else if (typ == 2) {
                    CurrentAccount acc = new CurrentAccount(accNumber, name, balence);
                    bank.addAccount(acc);
                }
                else{
                    System.out.println("Enter the correct choice");
                }
                
            }    
            else if (choice == 2) {
                
            }
            else if (choice == 3) {
                
            }
            else if (choice == 4) {
                
            }
            else if (choice == 5) {
                
            }
            else if (choice == 6) {
                
            }
            else if (choice == 7) {
                
            }
            else if (choice == 8) {
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
