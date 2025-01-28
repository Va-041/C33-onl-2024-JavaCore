package lesson11.homework.basicLevelTasks;

public class TaskOne extends MethodsForTasks {


    public static void taskOneStart() {
        System.out.println("\n=================== Task ONE ===================\n");
        getInputString();
        getStringLength();
        printStringLengths();
        getStringLengthsComparison();

        TaskOne taskOneInstance = new TaskOne();
        taskOneInstance.getRepeatMessage();
    }

    public static void getStringLengthsComparison() {
        if (stringArray.length == 0) {
            System.out.println("There are no entered strings for comparison.");
            return;
        }

        String longestString = stringArray[0];
        String shortestString = stringArray[0];
        int maxLength = stringArray[0].length();
        int minLength = stringArray[0].length();

        for (int i = 1; i < stringArray.length; i++) {
            if (stringArray[i].length() > maxLength) {
                maxLength = stringArray[i].length();
                longestString = stringArray[i];
            }
            if (stringArray[i].length() < minLength) {
                minLength = stringArray[i].length();
                shortestString = stringArray[i];
            }
        }

        System.out.println("\nThe longest string: \"" + longestString + "\", \nLength: " + maxLength);
        System.out.println("The shortest string: \"" + shortestString + "\", \nLength: " + minLength);
    }

    @Override
    public void repeatTask() {
        taskOneStart();
    }
}
