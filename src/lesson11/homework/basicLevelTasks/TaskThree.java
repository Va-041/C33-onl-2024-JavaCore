package lesson11.homework.basicLevelTasks;

public class TaskThree extends MethodsForTasks {

    public static void taskThreeStart() {
        System.out.println("\n=================== Task THREE ===================\n");

        getInputString();
        getStringLength();
        printStringLengths();
        getAverageStringLength();
        printStringsBelowAverageLength();


        TaskThree taskThreeInstance = new TaskThree();
        taskThreeInstance.getRepeatMessage();
    }

    public static double getAverageStringLength() {
        int totalLength = 0;

        for (int length : stringLengths) {
            totalLength += length;
        }

        return totalLength / (double) stringArray.length;
    }

    public static void printStringsBelowAverageLength() {
        double averageLength = getAverageStringLength();
        System.out.println("\nStrings with length below average (" + averageLength + "):");

        for (String str : stringArray) {
            if (str.length() < averageLength) {
                System.out.println(str);
            }
        }
    }

    @Override
    public void repeatTask() {
        taskThreeStart();
    }
}
