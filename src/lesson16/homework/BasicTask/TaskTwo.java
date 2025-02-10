package lesson16.homework.BasicTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskTwo {

    public static void startTaskTwo() {

        System.out.println("\n========== Task TWO ==========\n");

        getWordToMap();
        getRepeatMessage();
    }

    public static void getWordToMap() {
        Scanner scanner = getInputScanner();
        int wordCount = 0;

        //ввод количества слов
        while (true) {
            System.out.print("Enter the number of words (from 2 to 10): ");
            if (scanner.hasNextInt()) {
                wordCount = scanner.nextInt();
                if (wordCount >= 2 && wordCount <= 10) {
                    break;
                } else {
                    System.out.println("Please enter a number from 2 to 10.\n");
                }
            } else {
                System.out.println("Please enter a number, not another type of data.\n");
                scanner.next();
            }
        }

        //ввод слов
        String[] words = new String[wordCount];
        scanner.nextLine(); //очищаем буфер после ввода числа
        System.out.println();

        for (int i = 0; i < wordCount; i++) {
            while (true) {
                System.out.print("Enter a word (at least two letters): ");
                String word = scanner.nextLine();
                if (word.length() >= 2 && !word.trim().isEmpty()) {
                    words[i] = word;
                    break;
                } else {
                    System.out.println("The word must be at least two letters long and not be empty.\n");
                }
            }
        }

        //преобразуем слова в map и выводим результат
        Map<String, String> map = pairs(words);
        System.out.println("\nResult: " + map);
    }

    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            map.put(str.substring(0, 1), str.substring(str.length() - 1));
        }
        return map;
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
