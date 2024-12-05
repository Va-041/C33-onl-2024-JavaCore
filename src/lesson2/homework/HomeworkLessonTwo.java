package lesson2.homework;

import java.util.Locale;
import java.util.Scanner;

class HomeworkLessonTwo {
    public static void main(String[] args) {
        getResultTaskOne();
    }

    private static int currentTask = 1;

    public static void getResultTaskOne() {
        System.out.println("\n= = = = = = = = = = = Task №1 = = = = = = = = = = =\n");

        int valueB = getValidInt("Please, enter value B: ", 1);
        int valueC = getValidInt("Please, enter value C: ", 1);
        int valueA = 4 * (valueB + valueC - 1) / 2;
        System.out.println("The result of the calculation a = 4 * (b + c - 1)/2 = " + valueA);

        getChoiceAfterResult();
    }

    public static void getResultTaskTwo() {
        System.out.println("= = = = = = = = = = = Task №2 = = = = = = = = = = =\n");

        int valueTwoDigitN = getValidInt("Please, enter a two-digit number: ", 2);
        int firstDigit;
        int secondDigit;

        if (valueTwoDigitN < 0){
            firstDigit = -valueTwoDigitN / 10;
            secondDigit = -valueTwoDigitN % 10;
        } else {
            firstDigit = valueTwoDigitN / 10;
            secondDigit = valueTwoDigitN % 10;
        }

        int sumOfDigits = firstDigit + secondDigit;
        System.out.println("The sum of the digits of the number N: " + firstDigit + " + " + secondDigit + " = "
                + sumOfDigits );

        getChoiceAfterResult();
    }

    public static void getResultTaskThree() {
        System.out.println("= = = = = = = = = = = Task №3 = = = = = = = = = = =\n");

        int valueThreeDigitN = getValidInt("Please, enter a three-digit number: ", 3);
        int firstDigit;
        int secondDigit;
        int thirdDigit;

        if (valueThreeDigitN < 0){
            firstDigit = -valueThreeDigitN / 100;
            secondDigit = -(valueThreeDigitN / 10) % 10;
            thirdDigit = -valueThreeDigitN % 10;
        } else {
            firstDigit = valueThreeDigitN / 100;
            secondDigit = (valueThreeDigitN / 10) % 10;
            thirdDigit = valueThreeDigitN % 10;
        }

        int sumOfDigits = firstDigit + secondDigit + thirdDigit;
        System.out.println("The sum of the digits of the number N: " + firstDigit + " + " + secondDigit + " + " +
                thirdDigit + " = " + sumOfDigits);

        getChoiceAfterResult();
    }

    public static void getResultTaskFour() {
        System.out.println("= = = = = = = = = = = Task №4 = = = = = = = = = = =\n");

        double doubleValueN = getValidDouble("\nPlease, enter a real number with a non-zero " +
                "fractional part: ", -999, 999);

        int resultRounded;
        if (doubleValueN >= 0) {
            resultRounded = (int)(doubleValueN + 0.5);
        } else {
            resultRounded = (int)(doubleValueN - 0.5);
        }
        System.out.println("The result of rounding: " + resultRounded);
        //     String resultRounding = String.format("%.0f",valueN);
        //     System.out.print("The result of rounding: " + resultRounding);

        getChoiceAfterResult();
    }

    public static void getResultTaskFive() {
        System.out.println("= = = = = = = = = = = Task №5 = = = = = = = = = = =\n");

        int valueQ = getValidInt("Please, enter value Q: ", 1);
        int valueW = getValidInt("Please, enter value W: ", 1);

        if (valueW == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            int resultDivision = valueQ / valueW;
            int resultModulus = valueQ % valueW;

            if (valueQ < 0 && valueW < 0) {
                System.out.println("Result: " + valueQ + " / " + "(" + valueW + ")" + " = " + resultDivision + " and " +
                        resultModulus + " in modulus");

            } else if (valueQ > 0 && valueW < 0) {
                System.out.println("Result: " + valueQ + " / " + "(" + valueW + ")" + " = " + resultDivision + " and " +
                        resultModulus + " in modulus");

            } else {
                System.out.println("Result: " + valueQ + " / " + valueW + " = " + resultDivision + " and " +
                        resultModulus + " in modulus");
            }
        }

        getChoiceAfterResult();
    }

    public static void getResultTaskWithAsterisk() {
        System.out.println("= = = = = = = = Task  with asterisk = = = = = = = =\n");

        int valueA = getValidInt("Please, enter value A: ", 1);
        int valueB = getValidInt("Please, enter value B: ", 1);

        // Swap values using XOR
        valueA ^= valueB;
        valueB ^= valueA;
        valueA ^= valueB;

        System.out.println("\nResult:\nValue A = " + valueA + "\nValue B = " + valueB);

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
                    isValid = true; // Для однозначного числа просто разрешаем любой ввод
                } else if (digitCount == 2) {
                    if ((valueInt >= 10 && valueInt <= 99) || (valueInt <= -10 && valueInt >= -99)) {
                        isValid = true;
                    } else {
                        System.out.println("The entered number is not two-digit, repeat the input!");
                    }
                } else if (digitCount == 3) {
                    if ((valueInt >= 100 && valueInt <= 999) || (valueInt <= -100 && valueInt >= -999)) {
                        isValid = true;
                    } else {
                        System.out.println("The entered number is not three-digit, repeat the input!");
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

    public static double getValidDouble(String outputString, double min, double max) {

        Scanner inputDoubleValue = getScannerInput();
        inputDoubleValue.useLocale(Locale.ENGLISH);

        double valueDoubleN = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(outputString);

            if (inputDoubleValue.hasNextDouble()) {
                valueDoubleN = inputDoubleValue.nextDouble();

                // Проверка диапазона
                if (valueDoubleN >= min && valueDoubleN <= max) {
                    // Проверка наличия ненулевой дробной части
                    if (valueDoubleN % 1 != 0) {
                        isValid = true;
                    } else {
                        System.out.println("The number is an integer, please enter a number with a non-zero " +
                                "fractional part.");
                    }
                } else {
                    System.out.println("The entered number is out of range (" + min + " to " + max + "). " +
                            "Please repeat the input!");
                }
            } else {
                System.out.println("The entered value is not a valid double, please repeat the input!");
                inputDoubleValue.next(); // Очистка некорректного ввода
            }
        }

        return valueDoubleN;
    }

    public static void getChoiceAfterResult() {
        boolean validChoice = false;
        Scanner inputChoice = new Scanner(System.in);

        while (!validChoice) {
            System.out.print("\nSelect an action:");

            int optionNumber = 1; // Переменная для нумерации меню

            System.out.print("\n" + optionNumber++ + ". Repeat"); // 1. Repeat

            if (currentTask < 6) {
                System.out.print("\n" + optionNumber++ + ". To the next task"); // 2. To the next task
            }

            if (currentTask > 1) {
                System.out.print("\n" + optionNumber++ + ". To the previous task"); // 3. Go back to the previous task
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
                            getResultTaskFive();
                            break;
                        case 6:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (choiceAction == 2 && currentTask < 6) {
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
                            getResultTaskFive();
                            break;
                        case 6:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (currentTask == 6) {
                    // Специальная логика для задачи с астериском
                    if (choiceAction == 2) {
                        // Возврат к предыдущей задаче
                        currentTask--;
                        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
                        getResultTaskFive();
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
