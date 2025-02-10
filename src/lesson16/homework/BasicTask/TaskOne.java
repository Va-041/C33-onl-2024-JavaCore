package lesson16.homework.BasicTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskOne {

    public static void startTaskOne() {

        System.out.println("\n========== Task ONE ==========\n");

        getStringToMap();
        getRepeatMessage();
    }

    public static void getStringToMap() {

        Scanner scanner = getInputScanner();
        int numberOfRows = 0;

        //ввод числа строк от 2 до 10
        while (numberOfRows < 2 || numberOfRows > 10) {
            System.out.print("Enter the number of lines (from 2 to 10): ");
            if (scanner.hasNextInt()) {
                numberOfRows = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                if (numberOfRows < 2 || numberOfRows > 10) {
                    System.out.println("Incorrect input. Please enter a number from 2 to 10.");
                }
            } else {
                System.out.println("Incorrect input. Please enter a number from 2 to 10.");
                scanner.nextLine(); // Очистка буфера
            }
        }

        String[] words = new String[numberOfRows];
        int count = 0;

        // Ввод строк
        System.out.println("Enter the " + numberOfRows + " of rows\n");
        while (count < numberOfRows) {
            System.out.print("Enter the string: ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                words[count++] = input;
            } else {
                System.out.println("The string cannot be empty. Try again.");
            }
        }

        Map<String, Boolean> result = wordMultiple(words);
        System.out.println(result);
    }

    public static Map<String, Boolean> wordMultiple(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        Map<String, Boolean> result = new HashMap<>();
        System.out.println("\nResult: ");
        for (String word : countMap.keySet()) {
            result.put(word, countMap.get(word) >= 2);
        }

        return result;
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
