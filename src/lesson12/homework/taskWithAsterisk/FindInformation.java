package lesson12.homework.taskWithAsterisk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FindInformation {

    public static void startTaskWithAsterisk() {

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

            //   D:\\КУРСЫ ДЖАВА РАЗРАБОТЧИК\\HOMEWORKS\\JavaCore\\src\\lesson12\\homework\\taskWithAsterisk\\data
            //   src\\lesson12\\homework\\taskWithAsterisk\\data
            directory = new File(directoryPath);
            txtFiles = directory.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });

            if (txtFiles != null && txtFiles.length > 0) {
                isValidPath = true;
            } else {
                System.out.println("No .txt files found in the specified directory or the path is invalid. Please try again.");
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

                    String[] lines = readFileIntoArray(directory.getAbsolutePath() + File.separator + txtFiles[choice - 1]);
                    isValidChoice = true;
                    // построчный вывод, пользователю его видеть не надо
                    //for (String line : lines) {
                    //    System.out.println(line);
                    //}
                    // вызов метода на проверку строк с нужным нам регексом
                    String[][] validatedInfo = validateLines(lines);
                    // вызов метода показа инфы
                    displayFoundInfo(validatedInfo);
                } else {
                    System.out.println("Invalid choice. Please enter a number corresponding to the file or '0' to go back.");
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

    public static String[][] validateLines(String[] lines) {

        String docNumberRegex = "\\d{4}-\\d{4}-\\d{2}";
        String emailRegex = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        String phoneNumberRegex = "\\+\\(\\d{2}\\)\\d{7}";

        Pattern docNumberPattern = Pattern.compile(docNumberRegex);
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phoneNumberPattern = Pattern.compile(phoneNumberRegex);

        String[] docNumbers = new String[lines.length];
        String[] emails = new String[lines.length];
        String[] phoneNumbers = new String[lines.length];

        int docCount = 0;
        int emailCount = 0;
        int phoneCount = 0;

        for (String line : lines) {
            if (docNumberPattern.matcher(line).find()) {
                docNumbers[docCount++] = line;
            }
            if (emailPattern.matcher(line).find()) {
                emails[emailCount++] = line;
            }
            if (phoneNumberPattern.matcher(line).find()) {
                phoneNumbers[phoneCount++] = line;
            }
        }

        String[] finalDocNumbers = new String[docCount];
        String[] finalEmails = new String[emailCount];
        String[] finalPhoneNumbers = new String[phoneCount];

        System.arraycopy(docNumbers, 0, finalDocNumbers, 0, docCount);
        System.arraycopy(emails, 0, finalEmails, 0, emailCount);
        System.arraycopy(phoneNumbers, 0, finalPhoneNumbers, 0, phoneCount);

        return new String[][]{
                finalDocNumbers,
                finalEmails,
                finalPhoneNumbers
        };
    }

    public static void displayFoundInfo(String[][] validatedInfo) {

        System.out.println();
        if (validatedInfo[0].length == 0) {
            System.out.println("Document number: not found.");
        }
        if (validatedInfo[1].length == 0) {
            System.out.println("Email: not found.");
        }
        if (validatedInfo[2].length == 0) {
            System.out.println("Phone number: not found.");
        }

        for (String docNumber : validatedInfo[0]) {
            System.out.println("Document number: " + docNumber);
        }
        for (String email : validatedInfo[1]) {
            System.out.println("Email: " + email);
        }
        for (String phoneNumber : validatedInfo[2]) {
            System.out.println("Phone number: " + phoneNumber);
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
                    startTaskWithAsterisk();
                    validInput = true;
                    break;
                case "N":
                    System.out.println("Exiting the program. Goodbye!");
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
