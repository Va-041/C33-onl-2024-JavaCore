package lesson3.homework;

import java.util.Scanner;

public class HomeworkLessonThree {
    public static void main(String[] args) {
        getResultTaskOne();
    }

    public static int currentTask = 1;

    public static void getResultTaskOne(){

        System.out.println("\n= = = = = = = = = = = Task №1 = = = = = = = = = = =\n");

        int number = getValidInt("Please, enter some number: ", 1);

        if (number % 2 == 0) {
            System.out.println("Entered number is even");
        } else {
            System.out.println("Entered number is odd");
        }

        getChoiceAfterResult();
    }

    public static void getResultTaskTwo(){

        System.out.println("\n= = = = = = = = = = = Task №2 = = = = = = = = = = =\n");

        int valueTemperature = getValidInt("Please, Enter the temperature value (in degrees Celsius): ",
                2);

        if (valueTemperature > -5) {
            System.out.println("The temperature is warm");
        } else if (valueTemperature > -20) {
            System.out.println("The temperature is normal");
        } else {
            System.out.println("The temperature is cold");
        }

        getChoiceAfterResult();
    }

    public static void getResultTaskThree(){

        System.out.println("\n= = = = = = = = = = = Task №3 = = = = = = = = = = =\n");

        System.out.println("Squares of numbers from 10 to 20: ");

        for (int value = 10; value < 21; value++) {
            int valueSqr = value * value;
            if (valueSqr < 400) {
                System.out.print(valueSqr + " - ");
            } else {
                System.out.print(valueSqr);
            }
        }
        System.out.println();

        getChoiceAfterResult();
    }

    public static void getResultTaskFour(){

        System.out.println("\n= = = = = = = = = = = Task №4 = = = = = = = = = = =\n");

        System.out.println("A sequence of numbers from 7 to 100 in increments of +7: ");

        int valueStartSequence = 0;
        while (valueStartSequence + 7 < 100) {
            valueStartSequence += 7;

            if (valueStartSequence + 7 < 100) {
                System.out.print(valueStartSequence + " - ");
            } else {
                System.out.print(valueStartSequence);
            }
        }
        System.out.println();

        getChoiceAfterResult();
    }

    public static void getResultTaskWithAsterisk() {

        System.out.println("= = = = = = = = Task with asterisk = = = = = = = = =\n");

        int number = getValidInt("Please, enter some number: ", 3);

        int valueSumNumbers = 0;
        System.out.println("The sum of the numbers from 1 to " + number + ": ");

        for (int valueStartSum = 1; valueStartSum <= number; valueStartSum++) {
            valueSumNumbers += valueStartSum;
            System.out.print(valueStartSum);

            if (valueStartSum < number) {
                System.out.print(" + ");
            } else {
                System.out.print(" = ");
            }
        }
        System.out.println(valueSumNumbers);

        getChoiceAfterResult();
    }




    public static Scanner getScannerInput() {
        return new Scanner(System.in);
    }

    public static int getValidInt(String outputString, int digitCount) {

        Scanner inputValue = getScannerInput();

        int valueInt = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(outputString);
            if (inputValue.hasNextInt()) {
                valueInt = inputValue.nextInt();

                // Проверка в зависимости от количества разрядов
                if (digitCount == 1) {
                    if ((valueInt >= 0 && valueInt <= 999) || (valueInt <= -1 && valueInt >= -999)) {
                        isValid = true;
                    } else {
                        System.out.println("The value number is out of range -999 to 999. Please repeat the input!\n");
                    }
                } else if (digitCount == 2) {
                    if ((valueInt >= 0 && valueInt <= 100) || (valueInt <= -1 && valueInt >= -100)) {
                        isValid = true;
                    } else {
                        System.out.println("The entered value is out of range -100 to 100. Please repeat the input!\n");
                    }
                } else if (digitCount == 3) {
                    if ((valueInt >= 0 && valueInt <= 9999)) {
                        isValid = true;
                    } else {
                        System.out.println("The value number is out of range 0 to 9999. Please repeat the input!\n");
                    }
                } else {
                    System.out.println("Invalid digit count specification.");
                }
            } else {
                System.out.println("The entered value is not an integer, repeat the input!");
                inputValue.next(); // Очистка некорректного ввода
            }
        }
        return valueInt;
    }

    public static void getChoiceAfterResult() {
        boolean validChoice = false;
        Scanner inputChoice = new Scanner(System.in);

        while (!validChoice) {
            System.out.print("\nSelect an action:");

            int optionNumber = 1; // Переменная для нумерации меню

            System.out.print("\n" + optionNumber++ + ". Repeat"); // 1. Repeat

            if (currentTask < 5) {
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
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskOne();
                            break;
                        case 2:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskTwo();
                            break;
                        case 3:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskThree();
                            break;
                        case 4:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFour();
                            break;
                        case 5:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (choiceAction == 2 && currentTask < 5) {
                    // Переход к следующей задаче
                    currentTask++;
                    switch (currentTask) {
                        case 2:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskTwo();
                            break;
                        case 3:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskThree();
                            break;
                        case 4:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFour();
                            break;
                        case 5:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (currentTask == 5) {
                    // Специальная логика для последней задачи с астериском
                    if (choiceAction == 2) {
                        // Возврат к предыдущей задаче
                        currentTask--;
                        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                        getResultTaskFour();
                        validChoice = true;
                    } else if (choiceAction == 3) {
                        // Выход из программы
                        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                        System.out.println("Exiting...");
                        inputChoice.close();
                        System.exit(0);
                    } else {
                        System.out.println("\nChoose one of the available actions!");
                    }

                } else if (choiceAction == 3 && currentTask > 1) {
                    // Возврат к предыдущей задаче
                    currentTask--;
                    switch (currentTask) {
                        case 1:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskOne();
                            break;
                        case 2:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskTwo();
                            break;
                        case 3:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskThree();
                            break;
                        case 4:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFour();
                            break;
                        case 5:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (choiceAction == optionNumber && currentTask > 0) {
                    // Выход из программы
                    System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
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
