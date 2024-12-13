package lesson6.homework;

import java.util.Scanner;

public class CreditCard {
    String cardCompanyName;
    int accountNumber;
    int balance;

    public CreditCard(String cardCompanyName, int accountNumber, int balance) {
        this.cardCompanyName = cardCompanyName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void getGlobalInfoAboutCard() {
        System.out.println("-----------------------------------------");
        System.out.println("Card Company Name: " + cardCompanyName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------------------");
    }

    public void getBalance() {
        System.out.println("-----------------------------------------");
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------------------");
    }

    public void addCash() {

        Scanner inputCash = getScannerInput();
        System.out.println("-----------------------------------------");

        int amountToTopUp;
        while (true) {
            System.out.print("Please enter the amount to top-up your account: ");

            while (!inputCash.hasNextInt()) {
                System.out.print("Invalid input. Please enter a valid integer amount: ");
                inputCash.next(); // игнорируем некорректное значение
            }
            amountToTopUp = inputCash.nextInt();

            if (balance + amountToTopUp > 100000) {
                System.out.println("The amount to top-up exceeds the maximum balance limit of 100000.\n");
            } else {
                break; // значение корректное, выходим из цикла
            }
        }

        balance += amountToTopUp;
        System.out.println("Top-up successful.\n");
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------------------");
    }

    public void subtractCash() {

        Scanner inputCash = getScannerInput();
        System.out.println("-----------------------------------------");

        int amountToWithdraw;
        while (true) {
            System.out.print("Please enter the amount to withdraw in cash: ");

            while (!inputCash.hasNextInt()) {
                System.out.print("Invalid input. Please enter a valid integer amount: ");
                inputCash.next(); // игнорируем некорректное значение
            }
            amountToWithdraw = inputCash.nextInt();

            if ( amountToWithdraw > balance) {
                System.out.println("Insufficient funds. The amount to withdraw exceeds the current balance.\n");
            } else {
                break; // значение корректное, выходим из цикла
            }
        }

        balance -= amountToWithdraw;
        System.out.println("Withdrawal successful.\n");
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------------------");
    }




    public void getCardOperation() {
        Scanner inputChoice = getScannerInput();

        int intChoice;
        do {
            System.out.println("\nSelect an action: ");
            System.out.println("1. Get account information");
            System.out.println("2. Top up your balance");
            System.out.println("3. Withdraw cash");
            System.out.println("4. View the balance");
            System.out.println("5. Exit");
            System.out.print("\nYour choice: ");

            while (!inputChoice.hasNextInt()) {
                System.out.print("Invalid input. Please choose 1-5: ");
                inputChoice.next();
            }
            intChoice = inputChoice.nextInt();

            if (intChoice < 1 || intChoice > 5) {
                System.out.println("Invalid choice. Please choose 1-5");
            } else {
                System.out.println();
                switch (intChoice) {
                    case 1:
                        getGlobalInfoAboutCard();
                        getCardOperation();
                        break;
                    case 2:
                        addCash();
                        getCardOperation();
                        break;
                    case 3:
                        subtractCash();
                        getCardOperation();
                        break;
                    case 4:
                        getBalance();
                        getCardOperation();
                        break;
                    case 5:
                        return;
                }
            }
        } while (intChoice < 1 || intChoice > 5);
    }

    public Scanner getScannerInput() {
        return new Scanner(System.in);
    }
}
