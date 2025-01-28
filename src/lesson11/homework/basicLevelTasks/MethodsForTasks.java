package lesson11.homework.basicLevelTasks;

import java.util.Scanner;

public class MethodsForTasks {

    protected static String[] stringArray;
    protected static int[] stringLengths;

    public static void getInputString() {
        Scanner input = getInputScanner();

        int rowCount = 0;

        while (true) {
            System.out.print("How many strings will you enter? : ");
            if (input.hasNextInt()) {
                rowCount = input.nextInt();
                input.nextLine();

                if (rowCount >= 1 && rowCount <= 10) {
                    break; //корректный ввод, выходим из цикла
                } else {
                    System.out.println("Please enter a number between 1 and 10\n");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 10\n");
                input.next(); //очищаем некорректный ввод
            }
        }

        stringArray = new String[rowCount];
        System.out.println();

        for (int i = 0; i < stringArray.length; i++) {
            System.out.print("Enter the string: ");
            stringArray[i] = input.nextLine();
        }

        System.out.println("\nEntered strings:");
        for (String str : stringArray) {
            System.out.println(str);
        }
    }

    public static void getStringLength() {
        stringLengths = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            stringLengths[i] = stringArray[i].length();
        }
    }

    public static void printStringLengths() {
        System.out.println("\nThe lengths of the entered strings");

        for (int i = 0; i < stringLengths.length; i++) {
            System.out.println("String length \"" + stringArray[i] + "\": " + stringLengths[i]);
        }
    }

    public void getRepeatMessage() {
        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it?   Enter Y or N:  ");
            userInput = scanner.next().charAt(0);

            if (userInput == 'Y' || userInput == 'y') {
                repeatTask();
                return;
            } else if (userInput == 'N' || userInput == 'n') {
                System.out.println("\n\nExit from " + this.getClass().getSimpleName() + "...");
                break;
            } else {
                System.out.println("\nIncorrect input. Please enter Y or N.");
            }
        }
    }

    //метод-заглушка для переопределения
    public void repeatTask() {
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }
}
