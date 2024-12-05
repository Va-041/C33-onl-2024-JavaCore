package lesson4.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeworkLessonFour {

    public static void main(String[] args) {
        getResultTaskOne();
    }

    public static int currentTask = 1;

    public static void getResultTaskOne(){

        System.out.println("\n= = = = = = = = = Task №1 = = = = = = = = = =\n");

        int[] myArrayForTaskOne = getArray(1);

        System.out.println("\nArray values in direct order: ");
        for (int i = 0; i < myArrayForTaskOne.length; i++) {
            System.out.print(myArrayForTaskOne[i]);
            if (i < myArrayForTaskOne.length - 1) {
                System.out.print(" - ");
            }
        }

        System.out.println("\n\nArray values in reverse order: ");
        for (int i = myArrayForTaskOne.length - 1; i >= 0; i--) {
            if (i < myArrayForTaskOne.length - 1) {
                System.out.print(" - ");
            }
            System.out.print(myArrayForTaskOne[i]);
        }
        System.out.println();

        getChoiceAfterResult();
    }

    public static void getResultTaskTwo(){

        System.out.println("= = = = = = = = = Task №2 = = = = = = = = = =\n");

        int[] myArrayForTaskTwo = getArray(1);

        int minValue = myArrayForTaskTwo[0];
        for (int i = 0; i < myArrayForTaskTwo.length; i++) {
            if (myArrayForTaskTwo[i] < minValue) {
                minValue = myArrayForTaskTwo[i];
            }
        }
        System.out.println("\nThe minimum element of the array: " + minValue);

        int maxValue = myArrayForTaskTwo[0];
        for (int i = 0; i < myArrayForTaskTwo.length; i++) {
            if (maxValue < myArrayForTaskTwo[i]) {
                maxValue = myArrayForTaskTwo[i];
            }
        }
        System.out.println("The maximum element of the array: " + maxValue);

        getChoiceAfterResult();
    }

    public static void getResultTaskThree(){

        System.out.println("= = = = = = = = = Task №3 = = = = = = = = = =\n");

        int[] myArrayForTaskThree = getArray(1);

        int minValue = myArrayForTaskThree[0];
        int minIndexValue = 0;

        for (int i = 0; i < myArrayForTaskThree.length; i++) {
            if (myArrayForTaskThree[i] < minValue) {
                minValue = myArrayForTaskThree[i];
                minIndexValue = i;
            }
        }
        System.out.println("\nIndex of the minimum element of the array: " + minIndexValue);

        int maxValue = myArrayForTaskThree[0];
        int maxIndexValue = 0;

        for (int i = 0; i < myArrayForTaskThree.length; i++) {
            if (maxValue < myArrayForTaskThree[i]) {
                maxValue = myArrayForTaskThree[i];
                maxIndexValue = i;
            }
        }
        System.out.println("Index of the maximum element of the array: " + maxIndexValue);

        getChoiceAfterResult();
    }

    public static void getResultTaskFour(){

        System.out.println("= = = = = = = = = Task №4 = = = = = = = = = =\n");

        int[] myArrayForTaskFour = getArray(1);

        int zeroValueCounter = 0;
        String zeroIndices = "";

        for (int i = 0; i < myArrayForTaskFour.length; i++) {
            if (myArrayForTaskFour[i] == 0) {
                zeroValueCounter++;
                zeroIndices += i + " ";
            }
        }

        if (zeroValueCounter == 0) {
            System.out.println("\nThere are no zero elements in the array.");
        } else {
            System.out.println("\nThere are " + zeroValueCounter + " zero elements in the array.");
            System.out.println("Indices of zero elements: " + zeroIndices.trim());
        }

        getChoiceAfterResult();
    }

    public static void getResultTaskFive(){

        System.out.println("= = = = = = = = = Task №5 = = = = = = = = = =\n");

        int[] myArrayForTaskFive = getArray(1);

        //чтобы поменять элементы местами необходимо: завести цикл с перебором элементов, при каждой итерации менять
        //индекс каждого элемента начиная с начала (с нулевого и потом +1) на каждый элемент с конца (с последнего и -1)

        int initialIndex = 0;
        int finalIndex = myArrayForTaskFive.length - 1;


        for (int i = 0; i < myArrayForTaskFive.length / 2; i++) {
            int temp = myArrayForTaskFive[initialIndex];
            myArrayForTaskFive[initialIndex] = myArrayForTaskFive[finalIndex];
            myArrayForTaskFive[finalIndex] = temp;
            initialIndex++;
            finalIndex--;
        }

        System.out.println("\nAn array with changed positions of elements (the first is the last, the second is the " +
                "penultimate, etc.)");
        for (int i = 0; i < myArrayForTaskFive.length; i++) {
            System.out.print(myArrayForTaskFive[i]);
            if (i < myArrayForTaskFive.length - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();

        getChoiceAfterResult();
    }

    public static void getResultTaskSix(){

        System.out.println("= = = = = = = = = Task №6 = = = = = = = = = =\n");

        // если каждое следующее число больше предыдущего: для этого надо перебрать элементы массива, на каждой
        // итерации сравнивать число с предыдущим

        int[] myArrayForTaskSix = getArray(1);

        boolean isIncreasing = true;

        for (int i = 1; i < myArrayForTaskSix.length; i++) {
            if (myArrayForTaskSix[i] <= myArrayForTaskSix[i - 1]) {
                isIncreasing = false;
                break;
            }
        }
        if (isIncreasing) {
            System.out.println("\nThe array is an increasing sequence!   :)");
        } else {
            System.out.println("\nThe array is not an increasing sequence!   :(");
        }

        getChoiceAfterResult();
    }

    public static void getResultTaskWithAsterisk() {

        System.out.println("= = = = = = = = Task with asterisk = = = = = = = = =\n");

        // Получаем первоначальный массив
        int[] myArrayForTaskWithAsterisk = getArray(2);

        // Преобразуем массив в строку
        String numberStr = "";
        for (int i = 0; i < myArrayForTaskWithAsterisk.length; i++) {
            numberStr += myArrayForTaskWithAsterisk[i];
        }

        // Преобразуем строку в число и добавляем 1
        long number = Long.parseLong(numberStr);
        number += 1;

        // Выводим промежуточное число
        System.out.println("Number after adding 1: " + number);

        // Определяем количество цифр в новом числе
        long temp = number;
        int digitCounter = 0;
        while (temp > 0) {
            digitCounter++;
            temp /= 10;
        }

        // Преобразуем число обратно в массив цифр
        int[] arrayWithPlusOne = new int[digitCounter];
        for (int i = digitCounter - 1; i >= 0; i--) {
            arrayWithPlusOne[i] = (int) (number % 10);
            number /= 10;
        }

        // Выводим новый массив
        System.out.println("\nThe array after adding 1:");
        for (int i = 0; i < arrayWithPlusOne.length; i++) {
            System.out.print(arrayWithPlusOne[i]);
            if (i < arrayWithPlusOne.length - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();

        getChoiceAfterResult();
    }






    public static Scanner getScannerInput() {
        return new Scanner(System.in);
    }

    public static int[] getArray(int digitCount) {
        int arrayLength;
        if (digitCount == 1) {
            arrayLength = getValidArrayLength("Please enter the size of the array (1~100): ", digitCount);
        } else {
            arrayLength = getValidArrayLength("Please enter the size of the array (1~10): ", digitCount);
        }
        int[] arrayValues = new int[arrayLength];

        Scanner input = getScannerInput();

        int intChoice;
        do {
            System.out.println("\nChoose how to fill the array values: ");
            System.out.println("1. Manually");
            System.out.println("2. Automatically");
            System.out.print("\nYour choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid choice. Please choose 1 or 2.");
                input.next();
            }
            intChoice = input.nextInt();

            if (intChoice != 1 && intChoice != 2) {
                System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        } while (intChoice != 1 && intChoice != 2);

        Random randomValues = new Random();
        for (int i = 0; i < arrayLength; i++) {
            if (intChoice == 1) {
                int value;
                do {
                    System.out.print("Enter value for element " + (i + 1) + ": ");
                    if (input.hasNextInt()) {
                        value = input.nextInt();
                        if (i == 0 && value == 0) {
                            System.out.println("First element cannot be zero. Please enter a different value\n");
                            value = -1;
                        } else if (value < 0 || value > 99999) {
                            System.out.println("Invalid value. Please enter a value between 0 and 99999\n");
                            value = -1;
                        }
                    } else {
                        System.out.println("Invalid input. Please enter an integer\n");
                        input.next();
                        value = -1;
                    }
                } while (value == -1);
                arrayValues[i] = value;
            } else {
                arrayValues[i] = randomValues.nextInt(100);
            }
        }

        System.out.println("\nThe array has been formed! \nArray size: " + arrayLength + "\nArray values: ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(arrayValues[i]);
            if (i < arrayLength - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();

        return arrayValues;
    }

    public static int getValidArrayLength(String outputString, int digitCount) {
        Scanner inputArrayLength = getScannerInput();

        int valueInt = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(outputString);
            if (inputArrayLength.hasNextInt()) {
                valueInt = inputArrayLength.nextInt();

                if (digitCount == 1) {
                    if (valueInt > 0 && valueInt < 101) {
                        isValid = true;
                    } else {
                        System.out.println("The value number is out of range 1 to 100. Please repeat the input!\n");
                    }
                } else if (digitCount == 2) {
                    if (valueInt > 0 && valueInt < 11) {
                        isValid = true;
                    } else {
                        System.out.println("The value number is out of range 1 to 10. Please repeat the input!\n");
                    }
                }
            } else {
                System.out.println("The entered value is not an integer, repeat the input!\n");
                inputArrayLength.next(); // Очистка некорректного ввода
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

            if (currentTask < 7) {
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
                            getResultTaskThree();
                            break;
                        case 4:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFour();
                            break;
                        case 5:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFive();
                            break;
                        case 6:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskSix();
                            break;
                        case 7:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (choiceAction == 2 && currentTask < 7) {
                    // Переход к следующей задаче
                    currentTask++;
                    switch (currentTask) {
                        case 2:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskTwo();
                            break;
                        case 3:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskThree();
                            break;
                        case 4:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFour();
                            break;
                        case 5:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFive();
                            break;
                        case 6:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskSix();
                            break;
                        case 7:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskWithAsterisk();
                            break;
                    }
                    validChoice = true;

                } else if (currentTask == 7) {
                    // Специальная логика для последней задачи с астериском
                    if (choiceAction == 2) {
                        // Возврат к предыдущей задаче
                        currentTask--;
                        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                        getResultTaskSix();
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
                            getResultTaskThree();
                            break;
                        case 4:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFour();
                            break;
                        case 5:
                            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -\n\n");
                            getResultTaskFive();
                            break;
                    }
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