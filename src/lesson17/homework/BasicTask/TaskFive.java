package lesson17.homework.BasicTask;

import java.util.Scanner;
import java.util.function.Supplier;

public class TaskFive {

    public static void startTaskFive() {

        System.out.println("\n========== Task FIVE ==========\n");

        makeReverseString();
        getRepeatMessage();
    }

    public static void makeReverseString() {

        System.out.println("Enter a string: ");
        Scanner scanner = new Scanner(System.in);

        Supplier<String> inputSupplier = () -> {
            String input = scanner.nextLine();
            return new StringBuilder(input).reverse().toString();
        };

        String reversedString = inputSupplier.get();
        System.out.println("\nReversed string:  \n" + reversedString);
    }

    public static void getRepeatMessage() {

        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it? Enter Y or N: ");
            userInput = scanner.next().charAt(0);

            if (userInput == 'Y' || userInput == 'y') {
                startTaskFive();
                return;
            } else if (userInput == 'N' || userInput == 'n') {
                System.out.println("\n\nExit from Task FIVE...");
                break;
            } else {
                System.out.println("\nIncorrect input. Please enter Y or N.");
            }
        }
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }
}
