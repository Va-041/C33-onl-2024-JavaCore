package lesson12.homework.basicTask;

import java.util.Scanner;

public class FindingAbbreviations {

    public static void startBasicTask() {

        System.out.println("\n=============== Basic TASK ===============\n");

        String inputString = getInputString();
        String[] words = splitInputString(inputString);
        makeCheckWordsToBeAbbreviations(words);
    }

    public static String getInputString() {
        Scanner inputString = getInputScanner();
        System.out.print("Please enter a string: ");
        String userInput = inputString.nextLine();

        while (userInput.trim().isEmpty()) {
            System.out.println("Your string is empty! Repeat the input\n");
            System.out.print("Please enter a string: ");
            userInput = inputString.nextLine();

        }
        System.out.println("\nEntered string: " + userInput);
        System.out.println();

        return userInput;
    }

    public static String[] splitInputString(String userInput) {

        String[] words = userInput.split("\\P{L}+");

        System.out.println("\nWe split this string and have some words: ");
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                System.out.println(word);
            }
        }

        return words;
    }

    public static void makeCheckWordsToBeAbbreviations(String[] words) {

        //цикл для получения числа подходящих слов, чтобы потом сделать массив нужного размера
        int count = 0;
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                if (word.length() >= 2 && word.length() <= 6 && word.matches("[A-ZА-Я]+")) {
                        count++;
                }
            }
        }

        //цикл для записи подошедших слов в массив аббревиатур
        String[] abbreviations = new String[count];
        int index = 0;
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                if (word.length() >= 2 && word.length() <= 6 && word.matches("[A-ZА-Я]+")) {
                    abbreviations[index++] = word;
                }
            }
        }

        System.out.println("\nAbbreviations Array:");
        for (String abbreviation : abbreviations) {
            System.out.println(abbreviation);
        }
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }
}
