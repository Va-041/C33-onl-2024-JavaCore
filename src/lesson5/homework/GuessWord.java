package lesson5.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {

    public static void main(String[] args){
        // 1. Welcoming statement
        // 2. Instruction -> if you consider to play, enter y -> next step, if n -> leave
        // 2.1. if leave -> finish the game
        // 2.2. if move on ->
        // 3. Let's have a set of words and try to guess this words
        // 4. We need to offer a player to guess a word or a letter
        // 5. If one letter has been entered -> guess a letter
        // 5.1. if more than one letter has been entered -> guess the word
        // 6. If you have guessed a word, check, YOU WON
        // 6.1. Ask would you like to play again and repeat the whole game
        // 6.2. If not, continue
        // 7. If you have guessed a letter, move on until all letters are opened
        // 7.1. If you have not guessed a letter ask to repeat
        // Проверка на повторы - если у меня в массиве две Р, три А, они все должны быть показаны
        // Открыты и больше он не должен на них реагировать или же сказать, что вы уже эту букву открыли
        startGame();
    }

    public static void startGame() {
        welcome();

        char[] hiddenWord = getHiddenWord().toCharArray();
        char[] openWord = new char[hiddenWord.length];
        Arrays.fill(openWord, '*');

        playOrNot();

        // Устанавливаем количество попыток
        int attempts = 20;

        if (getInput().nextLine().equalsIgnoreCase("Y")) {
            // Play game...
            getMessagePlay();
            printWord(openWord);
            System.out.println();
            getInputMsg();

            while (attempts > 0) {
                String input = getInput().nextLine().trim(); // убираем пробелы в начале и в конце

                if (input.isEmpty()) {
                    // если ничего не введено
                    System.out.print("You have entered no value. Please, re-enter: ");
                    continue;
                } else if (input.length() == 1 || (input.length() == 2 && input.contains(" "))) {
                    // если введено одно значение или два символа, один из которых пробел
                    boolean found = checkLetter(input, hiddenWord, openWord);
                    if (found && Arrays.equals(hiddenWord, openWord)) {
                        System.out.println("You've guessed the word: " + new String(hiddenWord));
                        getWonMessage();
                        break;
                    }
                } else {
                    // если введено более одного значения
                    if (input.contains(" ")) {
                        // если введенное значение содержит пробелы
                        System.out.print("Input contains spaces. Please enter a single letter or a whole word without spaces: ");
                        continue;
                    }
                    if (checkWord(input, hiddenWord)) {
                        return;
                    }
                }

                // Уменьшаем количество оставшихся попыток
                attempts--;
                System.out.println("Attempts remaining: " + attempts);

                if (attempts == 0) {
                    getLostMessage();
                    break;
                }

                // вывод сообщения для следующего ввода
                System.out.print("Please, enter a letter or a whole word: ");
            }

            // предложить пользователю сыграть еще раз
            System.out.print("\n\nDo you want to play again? (Y/N): ");
            if (getInput().nextLine().equalsIgnoreCase("Y")) {
                startGame(); // перезапуск игры
            } else {
                System.out.println("\u001B[35m" + "You have decided to leave the game... GOODBYE!" + "\u001B[0m");
            }
        } else {
            System.out.println("\u001B[35m" + "You have decided to leave the game... GOODBYE!" + "\u001B[0m");
        }
    }

    public static void welcome(){
        System.out.println("\u001B[34m");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Welcome to Guess a Word Game by TMS.");
        System.out.println("The instructions are the following.");
        System.out.println("If you enter a letter, we will check if there is a match.");
        System.out.println("If there is, we open it on the table and game moves on.");
        System.out.println("If not, repeat and try to guess a letter.");
        System.out.println("If you have guessed all letters, you HAVE WON.");
        System.out.println("If you enter two or more characters than we check a word fully.");
        System.out.println("If you guessed the word, you HAVE WON.");
        System.out.println("If not, you continue the game.");
        System.out.println("------------------------------------------------------------------" + "\u001B[0m");
    }

    public static String[] getArrayOfWords(){
        return new String[]{
                "Apple",
                "Banana",
                "Flat",
                "House",
                "Pineapple",
                "Belarus",
                "Georgia",
                "Infrastructure",
                "Housewife",
                "Feminist",
                "Universe",
                "Galaxy",
                "Stars",
                "Mexico",
                "Watermelon",
                "Housekeeper"
        };
    }

    public static String getHiddenWord(){
        String[] hiddenWord = getArrayOfWords();

        return hiddenWord[new Random().nextInt(0, hiddenWord.length)];
    }

    public static Scanner getInput(){
        return new Scanner(System.in);
    }

    public static void playOrNot(){
        System.out.println("\u001B[31m" + "------------------------------------------------------------------");
        System.out.print("If you want to play, enter Y or any other value to leave: " + "\u001B[0m");
    }

    public static void getMessagePlay(){
        System.out.println("Hidden word has been set. We can start a game now...\n");
    }

    public static void printWord(char[] word){
        for(char element : word){
            System.out.print(element + "  ");
        }
    }

    public static void getInputMsg(){
        System.out.print("\nYou see a hidden word on your screen. \n\nPlease, enter a letter or a whole word: ");
    }

    public static boolean checkLetter(String input, char[] hiddenWord, char[] openWord) {

        boolean found = false;
        // получаем первую букву, если введено два символа с пробелом, приведение к нижнему регистру
        char letter = input.trim().toLowerCase().charAt(0);
        for (int i = 0; i < hiddenWord.length; i++) {
            if (Character.toLowerCase(hiddenWord[i]) == letter) {
                openWord[i] = hiddenWord[i]; // сохраняем исходный регистр
                found = true;
            }
        }

        if (found) {
            System.out.println("\nYour hidden word now equals: ");
            for(char element : openWord){
                System.out.print(element + "  ");
            }
            System.out.println("\n");
        } else {
            System.out.println("The letter " + letter + " is not in the word.");
        }
        return found;
    }

    public static boolean checkWord(String input, char[] hiddenWord) {
        // Преобразуем input и hiddenWord в нижний регистр для сравнения без учета регистра
        String lowerInput = input.toLowerCase();
        String lowerHiddenWord = new String(hiddenWord).toLowerCase();

        if (!lowerInput.equals(lowerHiddenWord)) {
            System.out.println("You have entered a wrong word.");
        } else {
            System.out.println("You've guessed the word: " + new String(hiddenWord));
            getWonMessage();

            // предложить пользователю сыграть еще раз
            System.out.print("\n\nDo you want to play again? (Y/N): ");
            if (getInput().nextLine().equalsIgnoreCase("Y")) {
                startGame(); // перезапуск игры
            } else {
                System.out.println("\u001B[35m" + "You have decided to leave the game... GOODBYE!" + "\u001B[0m");
            }
            return true;
        }
        return false;
    }

    public static void getWonMessage(){
        System.out.println("\u001B[33m\t" + "Congratulations! YOU HAVE WON!" + "\u001B[0m");
    }

    public static void getLostMessage(){
        System.out.println("\u001B[31m\t" + "You've used all your attempts. Game over!\"" + "\u001B[0m");
    }
}
