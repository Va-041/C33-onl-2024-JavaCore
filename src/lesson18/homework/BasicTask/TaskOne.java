package lesson18.homework.BasicTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaskOne {

    public static void startTaskOne() {

        System.out.println("\n========== Task ONE ==========\n");

        List<Integer> numbers = getArrayList();
        getArrayListWithCorrectCondition(numbers);
        getRepeatMessage();
    }

    public static List<Integer> getArrayList() {

        List<Integer> numbers = new ArrayList<>();
        Scanner input = getInputScanner();
        Random rand = new Random();

        int numberOfItems = 0;
        while (true) {
            System.out.print("Enter the number of items to be added (from 5 to 10): ");
            if (input.hasNextInt()) {
                numberOfItems = input.nextInt();
                if (numberOfItems >= 5 && numberOfItems <= 10) {
                    break;
                } else {
                    System.out.println("Please enter a number between 5 and 10.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next();
            }
        }

        for (int i = 0; i < numberOfItems; i++) {
            numbers.add(rand.nextInt(10) + 1);
        }

        System.out.println("\nArrayList: " + numbers);

        return numbers;
    }

    public static void getArrayListWithCorrectCondition(List<Integer> numbers) {

        //удаляем дубликаты значений
        List<Integer> distinctNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (!distinctNumbers.contains(num)) {
                distinctNumbers.add(num);
            }
        }
        System.out.println("\nArraylist without duplicates: " + distinctNumbers);

        //только чётные элементы
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer num : distinctNumbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        System.out.println("\nArrayList with even elements: " + evenNumbers);

        //cуммa оставшихся элементов
        int sum = 0;
        for (Integer num : evenNumbers) {
            sum += num;
        }
        System.out.println("\nThe sum of the remaining even elements " + sum);
    }

    public static void getRepeatMessage() {

        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it? Enter Y or N: ");
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
