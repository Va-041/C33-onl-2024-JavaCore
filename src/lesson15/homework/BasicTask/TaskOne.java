package lesson15.homework.BasicTask;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TaskOne {

    public static void startTaskOne() {

        System.out.println("\n========== Task ONE ==========\n");

        getValuesForSet();
    }

    public static void getValuesForSet() {

        System.out.println("Enter a sequence of numbers separated by a space: ");

        Scanner inputValues = getInputScanner();
        String sequence = inputValues.nextLine();

        Set<Integer> valueSet = new HashSet<>();
        String[] numbers = sequence.split(" ");

        try {
            for (String num : numbers) {
                valueSet.add(Integer.parseInt(num));
            }

            StringBuilder result = new StringBuilder();
            for (Integer value : valueSet) {
                result.append(value).append(" ");
            }

            System.out.println("\nThe sequence after processing:");
            System.out.println(result.toString().trim());

        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number! " + e.getMessage() + "\n");
            getValuesForSet();
        }

        getRepeatMessage();
    }

    public static void getRepeatMessage() {
        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it?   Enter Y or N:  ");
            userInput = scanner.next().charAt(0);

            if (userInput == 'Y' || userInput == 'y') {
                startTaskOne();
                return;
            } else if (userInput == 'N' || userInput == 'n') {
                System.out.println("\n\nExit from Task ONE...");
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
