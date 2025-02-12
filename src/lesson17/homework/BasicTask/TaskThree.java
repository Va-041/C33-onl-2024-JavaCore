package lesson17.homework.BasicTask;

import java.util.Scanner;
import java.util.function.Function;

public class TaskThree {

    public static void startTaskThree() {

        System.out.println("\n========== Task THREE ==========\n");
        makeConvertation();
        getRepeatMessage();
    }

    public static void makeConvertation() {

        Scanner inputValue = getInputScanner();
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the amount in the '*amount* BYN' format: ");
            input = inputValue.nextLine();

            if (input.matches("\\d+ BYN")) {
                validInput = true;
            } else {
                System.out.println("Incorrect input. Please enter a positive number without spaces in the format " +
                        "'*sum* BYN'.\n");
            }
        }

        Function<String, String> convertAndFormat = byn -> {

            String[] parts = byn.split(" ");
            double bynAmount = Double.parseDouble(parts[0]);
            double exchangeRate = 3.27; // курс буна к доллару
            double usdAmount = bynAmount / exchangeRate;

            String formattedUsd = String.format("%,.2f", usdAmount);

            return formattedUsd + " USD";
        };

        String result = convertAndFormat.apply(input);
        System.out.println("\nConverted amount: " + result);
    }

    public static void getRepeatMessage() {

        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it? Enter Y or N: ");
            userInput = scanner.next().charAt(0);

            if (userInput == 'Y' || userInput == 'y') {
                startTaskThree();
                return;
            } else if (userInput == 'N' || userInput == 'n') {
                System.out.println("\n\nExit from Task THREE...");
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
