package lesson20.homework.BasicTask;

import java.util.Random;
import java.util.Scanner;

public class TaskTwo {

    public static void startTaskTwo() {

        System.out.println("\n========== Task TWO ==========\n");

        int[] numbers = getArrayNumbers();
        makeSortInThread(numbers);
        getRepeatMessage();
    }

    public static int[] getArrayNumbers() {
        Scanner input = getInputScanner();
        int numberOfElements;

        while (true) {
            System.out.print("Enter the number of values (from 10 to 100): ");
            if (input.hasNextInt()) {
                numberOfElements = input.nextInt();
                if (numberOfElements >= 10 && numberOfElements <= 100) {
                    break;
                } else {
                    System.out.println("Please enter a number from 10 to 100.\n");
                }
            } else {
                System.out.println("Incorrect input. Please enter an integer.\n");
                input.next();
            }
        }

        int[] numbers = new int[numberOfElements];
        Random rand = new Random();

        //заполнение массива случайными значениями
        for (int i = 0; i < numberOfElements; i++) {
            numbers[i] = rand.nextInt(50) + 1;
        }

        System.out.println("\nArray of values: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        return numbers;
    }

    public static void makeSortInThread(int[] numbers) {
        Thread insertionSortThread = new Thread(new InsertionSort(numbers));
        Thread selectionSortThread = new Thread(new SelectionSort(numbers));
        Thread bubbleSortThread = new Thread(new BubbleSort(numbers));

        insertionSortThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        selectionSortThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bubbleSortThread.start();

        try {
            insertionSortThread.join();
            selectionSortThread.join();
            bubbleSortThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InsertionSort implements Runnable {

        private int[] numbers;

        public InsertionSort(int[] numbers) {
            this.numbers = numbers.clone();
        }

        @Override
        public void run() {

            long startTime = System.nanoTime();
            for (int i = 1; i < numbers.length; i++) {
                int key = numbers[i];
                int j = i - 1;
                while (j >= 0 && numbers[j] > key) {
                    numbers[j + 1] = numbers[j];
                    j = j - 1;
                }
                numbers[j + 1] = key;
            }
            long endTime = System.nanoTime();
            System.out.println("Insertion sorted array: " + arrayToString(numbers));
            System.out.println("Insertion sort time: " + (endTime - startTime) + " ms");
        }
    }

    static class SelectionSort implements Runnable {

        private int[] numbers;

        public SelectionSort(int[] numbers) {
            this.numbers = numbers.clone();
        }

        @Override
        public void run() {

            long startTime = System.nanoTime();
            for (int i = 0; i < numbers.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] < numbers[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = numbers[minIndex];
                numbers[minIndex] = numbers[i];
                numbers[i] = temp;
            }
            long endTime = System.nanoTime();
            System.out.println("\nSelection sorted array: " + arrayToString(numbers));
            System.out.println("Selection sort time: " + (endTime - startTime) + " ms");
        }
    }

    static class BubbleSort implements Runnable {

        private int[] numbers;

        public BubbleSort(int[] numbers) {
            this.numbers = numbers.clone();
        }

        @Override
        public void run() {

            long startTime = System.nanoTime();
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length - i - 1; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
            }
            long endTime = System.nanoTime();
            System.out.println("\nBubble sorted array: " + arrayToString(numbers));
            System.out.println("Bubble sort time: " + (endTime - startTime) + " ms");
        }
    }


    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
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
