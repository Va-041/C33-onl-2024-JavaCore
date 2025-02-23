package lesson20.homework.TaskWithAsterisk;

import java.util.*;

public class TaskWithAsterisk {

    public static void startTaskWithAsterisk() {

        System.out.println("\n========== Task with ASTERISK ==========\n");


        getRepeatMessage();
    }


    public static void getRepeatMessage() {

        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it? Enter Y or N: ");
            userInput = scanner.next().charAt(0);

            if (userInput == 'Y' || userInput == 'y') {
                startTaskWithAsterisk();
                return;
            } else if (userInput == 'N' || userInput == 'n') {
                System.out.println("\n\nExit from Task with ASTERISK...");
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
