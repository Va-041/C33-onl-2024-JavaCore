package lesson11.homework.basicLevelTasks;

import java.util.Scanner;

public class TaskFive extends MethodsForTasks {

    public static void taskFiveStart() {
        System.out.println("\n=================== Task FIVE ===================\n");

        getInputString();

        // Дублирование каждого символа в строке
        String duplicatedString = duplicateCharacters(stringArray[0]);
        System.out.println("\nDuplicated string: :");
        System.out.println(duplicatedString);

        TaskFive taskFiveInstance = new TaskFive();
        taskFiveInstance.getRepeatMessage();
    }

    public static void getInputString() {
        Scanner input = getInputScanner();

        System.out.print("Enter string: ");
        stringArray = new String[1];
        stringArray[0] = input.nextLine();

        System.out.println("\nEntered string:");
        System.out.println(stringArray[0]);
    }

    public static String duplicateCharacters(String input) {

        StringBuilder duplicated = new StringBuilder();
        for (char c : input.toCharArray()) {
            duplicated.append(c).append(c);
        }
        return duplicated.toString();
    }

    @Override
    public void repeatTask() {
        taskFiveStart();
    }
}
