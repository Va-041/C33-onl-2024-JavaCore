package lesson17.homework.BasicTask;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

public class TaskTwo {

    public static void startTaskTwo() {

        System.out.println("\n========== Task TWO ==========\n");

        inputArraySize();
        getRepeatMessage();
    }

    public static void inputArraySize() {

        Scanner input = getInputScanner();
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите количество чисел (от 10 до 100): ");
            if (input.hasNextInt()) {
                n = input.nextInt();
                if (n >= 10 && n <= 100) {
                    validInput = true;
                } else {
                    System.out.println("Пожалуйста, введите число в диапазоне от 10 до 100.\n");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.\n");
                input.next(); // очищаем неправильный ввод
            }
        }

        int[] numbers = generateRandomNumbers(n);
        System.out.println("\nМассив случайных чисел: " + Arrays.toString(numbers));

        int[] positiveNumbers = filterPositiveNumbers(numbers);
        System.out.println("\nПоложительные числа: " + Arrays.toString(positiveNumbers));
    }

    private static int[] generateRandomNumbers(int n) {

        Random random = new Random();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(151) - 50; //диапазон от -50 до 100
        }
        return numbers;
    }

    private static int[] filterPositiveNumbers(int[] numbers) {

        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x > 0;
            }
        };

        return Arrays.stream(numbers)
                .filter(isPositive::test)
                .toArray();
    }

    public static void getRepeatMessage() {

        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it? Enter Y or N: ");
            userInput = scanner.next().charAt(0);

            if (userInput == 'Y' || userInput == 'y') {
                startTaskTwo();
                return;
            } else if (userInput == 'N' || userInput == 'n') {
                System.out.println("\n\nExit from Task TWO...");
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
