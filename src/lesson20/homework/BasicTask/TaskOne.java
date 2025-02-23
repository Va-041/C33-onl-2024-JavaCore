package lesson20.homework.BasicTask;

import java.util.Scanner;

public class TaskOne {

    public static void startTaskOne() {

        System.out.println("\n========== Task ONE ==========\n");

        int[] numbers = getArray();
        startThreads(numbers);
        getRepeatMessage();
    }

    public static int[] getArray() {

        Scanner input = getInputScanner();
        int numberOfElements;

        while (true) {
            System.out.print("Enter the number of values (from 5 to 20): ");
            if (input.hasNextInt()) {
                numberOfElements = input.nextInt();
                if (numberOfElements >= 5 && numberOfElements <= 20) {
                    break;
                } else {
                    System.out.println("Please enter a number from 5 to 20.");
                }
            } else {
                System.out.println("Incorrect input. Please enter an integer.");
                input.next();
            }
        }

        int[] numbers = new int[numberOfElements];
        //проверка значения элементов
        for (int i = 0; i < numberOfElements; i++) {
            while (true) {
                System.out.print("Enter the value for the element " + (i + 1) + " (from 1 to 20): ");
                if (input.hasNextInt()) {
                    int value = input.nextInt();
                    if (value >= 1 && value <= 20) {
                        numbers[i] = value;
                        break;
                    } else {
                        System.out.println("Please enter a number from 1 to 20.");
                    }
                } else {
                    System.out.println("Incorrect input. Please enter an integer.");
                    input.next();
                }
            }
        }

        System.out.println("\nNumbers: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        return numbers;
    }

    public static void startThreads(int[] numbers) {

        Thread maxElemThread = new Thread(new FindMax(numbers));
        Thread minElemThread = new Thread(new FindMin(numbers));

        maxElemThread.start();
        minElemThread.start();

        //ждём завершение потоков
        try {
            maxElemThread.join();
            minElemThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //результаты
        System.out.println("\n\nMaximum value: " + FindMax.max);
        System.out.println("Minimum value: " + FindMin.min);
    }

    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int findMin(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    //класс для запуска метода findMax() в потоке
    static class FindMax implements Runnable {
        private int[] numbers;
        public static int max;

        public FindMax(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            max = findMax(numbers);
        }
    }

    //класс для запуска метода findMin() в потоке
    static class FindMin implements Runnable {
        private int[] numbers;
        public static int min;

        public FindMin(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            min = findMin(numbers);
        }
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
