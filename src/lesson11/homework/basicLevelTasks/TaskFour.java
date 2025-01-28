package lesson11.homework.basicLevelTasks;

public class TaskFour extends MethodsForTasks {

    public static void taskFourStart() {
        System.out.println("\n=================== Task FOUR ===================\n");

        getInputString();
        printUniqueWord();

        TaskFour taskFourInstance = new TaskFour();
        taskFourInstance.getRepeatMessage();
    }


    public static void printUniqueWord() {

        String uniqueWord = findFirstUniqueWord();
        if (uniqueWord != null) {
            System.out.println("\nThe first word with all unique characters is: " + uniqueWord);
        } else {
            System.out.println("\nNo words with all unique characters found.");
        }
    }

    public static String findFirstUniqueWord() {
        for (String line : stringArray) {
            String[] words = line.split("[\\s,!.]+");
            for (String word : words) {
                if (hasAllUniqueCharacters(word)) {
                    return word;
                }
            }
        }
        return null;
    }

    public static boolean hasAllUniqueCharacters(String word) {
        boolean[] charSet = new boolean[256];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (charSet[c]) {
                return false;
            }
            charSet[c] = true;
        }
        return true;
    }

    @Override
    public void repeatTask() {
        taskFourStart();
    }
}
