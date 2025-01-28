package lesson11.homework.basicLevelTasks;

public class TaskTwo extends MethodsForTasks {

    public static void taskTwoStart() {
        System.out.println("\n=================== Task TWO ===================\n");

        getInputString();
        getStringLength();
        printStringLengths();
        getSortedStringsByLength();

        TaskTwo taskTwoInstance = new TaskTwo();
        taskTwoInstance.getRepeatMessage();
    }

    public static void getSortedStringsByLength() {
        for (int i = 0; i < stringArray.length - 1; i++) {
            for (int j = i + 1; j < stringArray.length; j++) {

                if (stringArray[i].length() > stringArray[j].length()) {
                    // Меняем местами строки
                    String temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }

        System.out.println("\nSorted strings by length:");
        for (String str : stringArray) {
            System.out.println(str);
        }
    }

    @Override
    public void repeatTask() {
        taskTwoStart();
    }

}
