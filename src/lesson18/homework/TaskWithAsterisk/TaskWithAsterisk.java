package lesson18.homework.TaskWithAsterisk;

import java.util.*;

public class TaskWithAsterisk {

    public static void startTaskWithAsterisk() {

        System.out.println("\n========== Task with ASTERISK ==========\n");

        Map<Integer, String> dataSet = createDataSet();

        List<String> filteredNames = filterByRange(dataSet);

        List<String> oddLengthNames = filterByOddLength(filteredNames);

        reverseNames(oddLengthNames);

        getRepeatMessage();
    }

    public static Map<Integer, String> createDataSet() {

        Map<Integer, String> dataSet = new HashMap<>();
        dataSet.put(1, "Anna");
        dataSet.put(2, "Bobbic");
        dataSet.put(3, "Mickola");
        dataSet.put(4, "David");
        dataSet.put(5, "Eve");
        dataSet.put(6, "Franklin");
        dataSet.put(7, "Archil");
        dataSet.put(8, "Natasha");
        dataSet.put(9, "Ivan");
        dataSet.put(10, "Sasha");
        dataSet.put(11, "Katya");
        dataSet.put(12, "Dmitry");
        dataSet.put(13, "Anastasia");

        System.out.println("Put in MAP:\n");
        for(int i = 1; i <dataSet.size(); i++) {
            System.out.println(dataSet.get(i));
        }

        return dataSet;
    }

    public static List<String> filterByRange(Map<Integer, String> dataSet) {

        List<Integer> validIds = Arrays.asList(1, 2, 5, 8, 9, 13);
        List<String> filteredNames = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : dataSet.entrySet()) {
            if (validIds.contains(entry.getKey())) {
                filteredNames.add(entry.getValue());
            }
        }
        return filteredNames;
    }

    public static List<String> filterByOddLength(List<String> names) {

        List<String> oddLengthNames = new ArrayList<>();

        for (String name : names) {
            if (name.length() % 2 != 0) {
                oddLengthNames.add(name);
            }
        }
        return oddLengthNames;
    }

    public static void reverseNames(List<String> names) {

        List<String> reversedNames = new ArrayList<>();

        for (String name : names) {
            reversedNames.add(new StringBuilder(name).reverse().toString());
        }

        System.out.println("\nSelected and reversed names: " + reversedNames);
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
