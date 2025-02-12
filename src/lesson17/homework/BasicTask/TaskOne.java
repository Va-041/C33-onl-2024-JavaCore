package lesson17.homework.BasicTask;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskOne {

    public static void startTaskOne() {

        System.out.println("\n========== Task ONE ==========\n");

        birthdayDataReturn();
        getRepeatMessage();
    }

    public static void birthdayDataReturn() {

        Scanner inputDate = getInputScanner();
        DateTimeFormatter formatterSlash = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterDot = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = null;

        while (birthDate == null) {
            System.out.print("Enter your date of birth (dd/mm/yyyy or dd.mm.yyyy):  ");
            String birthDateInput = inputDate.nextLine();

            if (isValidDate(birthDateInput, formatterSlash)) {
                birthDate = LocalDate.parse(birthDateInput, formatterSlash);
            } else if (isValidDate(birthDateInput, formatterDot)) {
                birthDate = LocalDate.parse(birthDateInput, formatterDot);
            } else {
                System.out.println("The date format is incorrect. Please enter the date in the format dd/mm/yyyy or dd.mm.yyyy.\n");
            }
        }

        LocalDate hundredYearsLater = birthDate.plusYears(100);
        String formattedDate = hundredYearsLater.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("\nThe date when you turn 100 years old: " + formattedDate);
    }

    public static boolean isValidDate(String dateStr, DateTimeFormatter formatter) {

        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return dateStr.matches("\\d{2}/\\d{2}/\\d{4}") || dateStr.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
        } catch (DateTimeParseException e) {
            return false;
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
