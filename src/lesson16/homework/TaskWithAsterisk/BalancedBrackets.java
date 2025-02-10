package lesson16.homework.TaskWithAsterisk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    private static final Map<Character, Character> bracketPairs = new HashMap<>();

    static {
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
    }

    public static void startTaskWithAsterisk() {
        Scanner scanner = getInputScanner();
        System.out.println("\n========== Task with ASTERISK ==========\n");

        while (true) {
            System.out.println("Enter a string with parentheses: ");
            String input = scanner.nextLine();

            if (!containsAtLeastTwoBrackets(input)) {
                System.out.println("The string must contain at least two brackets. Repeat the input.\n");
                continue;
            }

            if (isBalanced(input)) {
                System.out.println("\nThe brackets are balanced.");
            } else {
                System.out.println("\nThe brackets are not balanced.");
            }
            break;
        }
    }

    private static boolean containsAtLeastTwoBrackets(String str) {
        String brackets = "[]{}()";
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (brackets.indexOf(ch) != -1) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (bracketPairs.containsValue(ch)) {
                stack.push(ch);
            } else if (bracketPairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != bracketPairs.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
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
                System.out.println("\n\nExit from Task with ASTERISK...\n");
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