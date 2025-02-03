package lesson14.homework.BasicTask;

import java.io.*;
import java.util.Scanner;

public class FindLongestWord {

    public static void startBasicTask() {

        System.out.println("\n=============== Task with Asterisk ===============");
        getFileForRead();
        repeatMethod();
    }

    public static void getFileForRead() {

        Scanner scanner = getInputScanner();
        boolean isValidPath = false;
        File directory = null;
        String[] txtFiles = null;

        while (!isValidPath) {
            System.out.print("\nEnter the directory path (or type 'Exit' to exit from programm): ");
            String directoryPath = scanner.nextLine();

            if (directoryPath.equalsIgnoreCase("Exit")) {
                continue;
            }

            //   src\\lesson14\\homework\\BasicTask\\data
            directory = new File(directoryPath);
            txtFiles = directory.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });

            if (txtFiles != null && txtFiles.length > 0) {
                isValidPath = true;
            } else {
                System.out.println("No .txt files found in the specified directory or the path is invalid. " +
                        "Please try again.");
            }
        }

        System.out.println("\nWhat file would you like to read?");
        for (int i = 0; i < txtFiles.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + txtFiles[i]);
        }
        System.out.println("\t0. Back");

        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.print("\nEnter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    getFileForRead();
                    return;
                } else if (choice > 0 && choice <= txtFiles.length) {
                    System.out.println("\nReading file " + txtFiles[choice-1] + " ...\n\nFile text:\n");
                    readFile(directory.getAbsolutePath() + File.separator + txtFiles[choice - 1]);

                    String[] lines = readFileIntoArray(directory.getAbsolutePath() + File.separator +
                            txtFiles[choice - 1]);
                    isValidChoice = true;

                    // построчный вывод, пользователю его видеть не надо
                    //for (String line : lines) {
                    //    System.out.println(line);
                    //}
                    String longestWord = findLongestWord(lines);
                    writeLongestWordToFile(longestWord, "src\\lesson14\\homework\\BasicTask\\data");

                } else {
                    System.out.println("Invalid choice. Please enter a number corresponding to the file or" +
                            " '0' to go back.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static void readFile(String filePath) {

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] readFileIntoArray(String filePath) {

        String[] lines = new String[0];

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            lines = fileScanner.useDelimiter("[,\\s]+").tokens().toArray(String[]::new);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static String findLongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static void writeLongestWordToFile(String longestWord, String directoryPath) {
        File file = new File(directoryPath, "the_longest_word.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(longestWord);
            System.out.println("\nThe longest word \"" + longestWord + "\" has been written to the file " +
                    "'the_longest_word.txt' in the directory: " + directoryPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void repeatMethod() {

        Scanner scanner = getInputScanner();
        boolean validInput = false;

        while (!validInput) {
            System.out.print("\nWould you like to repeat the program? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "Y":
                    startBasicTask();
                    validInput = true;
                    break;
                case "N":
                    System.out.println("\nExiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'Y' to repeat or 'N' to exit.");
                    break;
            }
        }
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }
}
