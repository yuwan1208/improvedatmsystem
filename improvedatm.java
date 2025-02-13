import java.util.Scanner;
import java.util.HashMap;

public class ImprovedATM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Integer> loginCredentials = new HashMap<Integer, Integer>();
        HashMap<Integer, Double> accountBalances = new HashMap<Integer, Double>();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.println("Choose an option: ");
            int option = input.nextInt();


            switch (option) {
                case 1:
                    System.out.println("Enter account number: ");
                    int accountnumber = input.nextInt();
                    System.out.println("Enter account pin: ");
                    int accountpin = input.nextInt();
                    loginCredentials.put(accountnumber, accountpin);
                    accountBalances.put(accountnumber, 0.0);
                    System.out.println("Account Succesfully Registered.");
                    break;

                case 2:
                    System.out.println("Enter account number: ");
                    int loginAccountNumber = input.nextInt();
                    System.out.println("Enter account pin: ");
                    int loginPin = input.nextInt();

                    if (loginCredentials.containsKey(loginAccountNumber)) {
                        int storedPin = loginCredentials.get(loginAccountNumber);
                        if (storedPin == loginPin) {
                            System.out.println("Login successful!");

                            double balance = accountBalances.get(loginAccountNumber);
                            while (true) {
                                System.out.println("\nATM Menu:");
                                System.out.println("1. Check Balance");
                                System.out.println("2. Deposit Money");
                                System.out.println("3. Withdraw Money");
                                System.out.println("4. Logout");

                                System.out.println("Choose an option: ");
                                int atmOption = input.nextInt();

                                switch (atmOption) {
                                    case 1:
                                        System.out.println("Your balance: $" + balance);
                                        break;
                                    case 2:
                                        System.out.println("Enter deposit amount: ");
                                        double depositAmount = input.nextDouble();
                                        balance += depositAmount;
                                        accountBalances.put(loginAccountNumber, balance);
                                        System.out.println("Deposit Successful. New balance: $" + balance);
                                        break;
                                    case 3:
                                        System.out.println("Enter withdrawal amount: ");
                                        double withdrawAmount = input.nextDouble();
                                        if (withdrawAmount > balance) {
                                            System.out.println("Insufficient funds! Your balance is $" + balance);
                                        } else {
                                            balance -= withdrawAmount;
                                            accountBalances.put(loginAccountNumber, balance);
                                            System.out.println("Withdrawal Successful. New balance: $" + balance);
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Logged out.");
                                        break;
                                    default:
                                        System.out.println("Invalid option. Please try again.");
                                }

                                if (atmOption == 4) {
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Invalid PIN. Please try again.");
                        }
                    } else {
                        System.out.println("Account number not found. Please register first.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");


            }
        }
    }
}