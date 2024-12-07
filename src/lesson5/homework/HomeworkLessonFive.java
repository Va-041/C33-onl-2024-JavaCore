package lesson5.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeworkLessonFive {

    public static void main(String[] args) {
        getResultTaskOne();
    }

    public static int currentTask = 1;

    public static void getResultTaskOne() {

        System.out.println("\n= = = = = = = = = Task №1 = = = = = = = = = =\n");


        Random randomValue =  new Random();
        int [][] arrayTwoDim = new int [randomValue.nextInt(2,6)][randomValue.nextInt(2,6)];

        for (int inner = 0; inner < arrayTwoDim.length; inner++) {
            for (int outer = 0; outer < arrayTwoDim[inner].length; outer++) {
                arrayTwoDim[inner][outer] = randomValue.nextInt(10);
            }
        }

        System.out.println("Your two-dimensional array is: ");
        for (int [] digits : arrayTwoDim) {
            for(int element : digits) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println();
        Scanner inputValue = getScannerInput();
        for (int inner = 0; inner < arrayTwoDim.length; inner++) {
            for (int outer = 0; outer < arrayTwoDim[inner].length; outer++) {
                int valueChek = -1;
                while (valueChek < 0 || valueChek > 99) {
                    System.out.print("Enter the number you want to add to the [" + inner + "][" + outer + "] " +
                            "element of the array (from 0 to 99): ");
                    if (inputValue.hasNextInt()) {
                        valueChek = inputValue.nextInt();
                        if (valueChek < 0 || valueChek > 99) {
                            System.out.println("Invalid input. Please enter a number between 0 and 99.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        inputValue.next(); // Очистка неверного ввода
                    }
                }
                arrayTwoDim[inner][outer] += valueChek;
            }
        }

        System.out.println();
        System.out.println("Your new two-dimensional array is: ");
        for (int [] digits : arrayTwoDim) {
            for(int element : digits) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        int sumValue = 0;
        System.out.println();
        for (int inner = 0; inner < arrayTwoDim.length; inner++) {
            for (int outer = 0; outer < arrayTwoDim[inner].length; outer++) {
                sumValue += arrayTwoDim[inner][outer];
            }
        }
        System.out.println("The sum of the two-dimensional array is: " + sumValue);

        getChoiceAfterResult();
    }

    public static void getResultTaskTwo() {

        System.out.println("\n= = = = = = = = = Task №2 = = = = = = = = = =\n");
        // высчитывает по строкам (первый индекс строка второй столбец, сперва проходит всю строку потом
        // переходит на другую)

        // W = 00 02 04 06
        //     11 13 15 17
        //     20 22 24 26
        //     ...

        // B = 01 03 05 07
        //     10 12 14 16
        //     21 23 25 27
        //     ...

        //     0 1 2 3 4 5 6 7

        // 0   W B W B W B W B
        // 1   B W B W B W B W
        // 2   W B W B W B W B
        // 3   B W B W B W B W
        // 4   W B W B W B W B
        // 5   B W B W B W B W
        // 6   W B W B W B W B
        // 7   B W B W B W B W

        // если элемент имеет первый индекс 0246 (чётная строка) а второй индекс чётный - пишем W (чёт, чёт)
        // если элемент имеет первый индекс 1357 (нечётная строка) а второй индекс тоже нечётный - пишем W (нечёт, нечёт)

        // если элемент имеет первый индекс 0246 (чётная строка) а второй индекс нечётный - пишем B (чёт, нечёт)
        // если элемент имеет первый индекс 1357 (нечётная строка) а второй индекс чётный - пишем B (нечёт, чёт)

        String [][] chessBoardArray = new String [8][8];

        for (int inner = 0; inner < chessBoardArray.length; inner++) {
            for (int outer = 0; outer < chessBoardArray[inner].length; outer++) {
                if (inner % 2 == 0 && outer % 2 == 0 || inner % 2 == 1 && outer % 2 == 1) {
                    chessBoardArray[inner][outer] = "W";
                } else {
                    chessBoardArray[inner][outer] = "B";
                }
            }
        }

        System.out.println();
        System.out.println("Your two-dimensional array in the form of a chessboard: ");
        for (String [] chessLetters : chessBoardArray) {
            for(String letter : chessLetters) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }

        getChoiceAfterResult();
    }

    public static void getResultTaskWithAsterisk() {

        System.out.println("\n= = = = = = = Task with asterisk = = = = = = = =\n");

        int rows, columns;

        while (true) {
            System.out.print("\nEnter the dimension of the two-dimensional array (the first number is the number " +
                    "of rows, the second is the number of columns) separated by a space: ");

            String inputDimension = getScannerInput().nextLine();
            String[] dimensions = inputDimension.split(" ");

            if (dimensions.length == 2) {
                boolean validInput = true;
                for (String dim : dimensions) {
                    for (char c : dim.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            validInput = false;
                            break;
                        }
                    }
                }
                if (validInput) {
                    rows = Integer.parseInt(dimensions[0]);
                    columns = Integer.parseInt(dimensions[1]);
                    if (rows >= 1 && rows <= 100 && columns >= 1 && columns <= 100) {
                        break;
                    } else {
                        System.out.println("Dimensions must be between 1 and 100. Please try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter two integer numbers.");
                }
            } else {
                System.out.println("Please enter exactly two numbers separated by a space.");
            }
        }


        int[][] snakeArray = new int [rows][columns];

        int arrayValue = 0;
        int maxValue = 1000; // Значения массива до 1000
        boolean shouldBreak = false;

        for (int inner = 0; inner < snakeArray.length; inner++) {
            for (int outer = 0; outer < snakeArray[inner].length; outer++) {
                if (arrayValue >= maxValue) {
                    shouldBreak = true;
                    break;
                }
                snakeArray[inner][outer] = arrayValue;
                arrayValue++;
            }
            if (shouldBreak) {
                System.out.println("\nThe maximum array value of 999 has been reached");
                break;
            }
        }

        System.out.println("\nYour two-dimensional array is: ");
        for (int i = 0; i < snakeArray.length; i++) {
            boolean hasNonZero = false;

            if (i % 2 == 0) { // Четные строки (слева направо)
                for (int j = 0; j < snakeArray[i].length; j++) {
                    if (snakeArray[i][j] == 0 && arrayValue > maxValue) {
                        break;
                    }
                    if (snakeArray[i][j] != 0 || (snakeArray[i][j] == 0 && arrayValue < maxValue)) {
                        hasNonZero = true;
                        System.out.print(String.format("%3d", snakeArray[i][j]) + " ");
                    }
                }
            } else { // Нечетные строки (справа налево)
                for (int j = snakeArray[i].length - 1; j >= 0; j--) {
                    if (snakeArray[i][j] == 0 && arrayValue > maxValue) {
                        break;
                    }
                    if (snakeArray[i][j] != 0 || (snakeArray[i][j] == 0 && arrayValue < maxValue)) {
                        hasNonZero = true;
                        System.out.print(String.format("%3d", snakeArray[i][j]) + " ");
                    }
                }
            }

            if (hasNonZero) {
                System.out.println();
            }
        }

        getChoiceAfterResult();
    }

    public static Scanner getScannerInput() {
        return new Scanner(System.in);
    }

    public static void getChoiceAfterResult() {
        boolean validChoice = false;
        Scanner inputChoice = new Scanner(System.in);

        while (!validChoice) {
            System.out.print("\nSelect an action:");

            int optionNumber = 1; // Переменная для нумерации меню

            System.out.print("\n" + optionNumber++ + ". Repeat"); // 1. Repeat

            if (currentTask < 3) {
                System.out.print("\n" + optionNumber++ + ". To the next task"); // 2. To the next task
            }

            if (currentTask > 1) {
                System.out.print("\n" + optionNumber++ + ". To the previous task"); // 3. To the previous task
            }

            System.out.print("\n" + optionNumber + ". Exit"); // 4. Exit

            System.out.print("\n\nYour choice: ");

            if (inputChoice.hasNextInt()) {
                int choiceAction = inputChoice.nextInt();

                if (choiceAction == 1) {
                    // Повтор текущей задачи
                    switch (currentTask) {
                        case 1:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskOne();
                            break;
                        case 2:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskTwo();
                            break;
                        case 3:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (choiceAction == 2 && currentTask < 3) {
                    // Переход к следующей задаче
                    currentTask++;
                    switch (currentTask) {
                        case 2:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskTwo();
                            break;
                        case 3:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (currentTask == 3) {
                    // Специальная логика для последней задачи с астериском
                    if (choiceAction == 2) {
                        // Возврат к предыдущей задаче
                        currentTask--;
                        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                        getResultTaskTwo();
                        validChoice = true;
                    } else if (choiceAction == 3) {
                        // Выход из программы
                        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                        System.out.println("Exiting...");
                        inputChoice.close();
                        System.exit(0);
                    } else {
                        System.out.println("\nChoose one of the available actions!");
                    }

                } else if (choiceAction == 3 && currentTask > 1) {
                    // Возврат к предыдущей задаче
                    currentTask--;
                    System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                    getResultTaskOne();
                    validChoice = true;

                } else if (choiceAction == optionNumber && currentTask > 0) {
                    // Выход из программы
                    System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                    System.out.println("\n\nExiting...");
                    inputChoice.close();
                    System.exit(0);
                } else {
                    System.out.println("\nChoose one of the available actions!");
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                inputChoice.next(); // очистка неправильного ввода
            }
        }
    }


}
