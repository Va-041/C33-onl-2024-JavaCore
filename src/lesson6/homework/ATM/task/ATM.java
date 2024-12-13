package lesson6.homework.ATM.task;

import java.util.Scanner;

public class ATM {

    int limitATM = 100000;
    int banknotesNominalTwenty;
    int banknotesNominalFifty;
    int banknotesNominalOneHundred;

    public ATM(int banknotesNominalTwenty, int banknotesNominalFifty, int banknotesNominalOneHundred) {
        this.banknotesNominalTwenty = banknotesNominalTwenty;
        this.banknotesNominalFifty = banknotesNominalFifty;
        this.banknotesNominalOneHundred = banknotesNominalOneHundred;
    }

    public void addFunds() {
        System.out.println("---------------------------------------");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите способ добавления денег");
            System.out.println("1. Ввести сумму полностью");
            System.out.println("2. Ввести купюры");
            System.out.println("3. Назад");
            System.out.print("\nYour choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение лишнего символа новой строки

            switch (choice) {
                case 1:
                    System.out.print("\nВведите сумму, которую хотите добавить (должна быть кратна 20, 50 или 100): ");
                    int totalAmount = scanner.nextInt();
                    scanner.nextLine();

                    if (totalAmount % 20 != 0 && totalAmount % 50 != 0 && totalAmount % 100 != 0) {
                        System.out.println("Сумма должна быть кратна 20, 50 или 100!");
                    } else {
                        int remainingAmount = totalAmount;
                        int addedHundreds = 0, addedFifties = 0, addedTwenties = 0;

                        while (remainingAmount >= 100 && totalBalance() + remainingAmount <= limitATM) {
                            banknotesNominalOneHundred++;
                            remainingAmount -= 100;
                            addedHundreds++;
                        }
                        while (remainingAmount >= 50 && totalBalance() + remainingAmount <= limitATM) {
                            banknotesNominalFifty++;
                            remainingAmount -= 50;
                            addedFifties++;
                        }
                        while (remainingAmount >= 20 && totalBalance() + remainingAmount <= limitATM) {
                            banknotesNominalTwenty++;
                            remainingAmount -= 20;
                            addedTwenties++;
                        }
                        System.out.println("Добавлено: " + totalAmount);
                        System.out.println("Купюры номиналом 100: " + addedHundreds);
                        System.out.println("Купюры номиналом 50: " + addedFifties);
                        System.out.println("Купюры номиналом 20: " + addedTwenties);
                        printBalance();
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("\nВыберите купюры, которыми хотите пополнить банкомат:");
                        System.out.println("1. 20");
                        System.out.println("2. 50");
                        System.out.println("3. 100");
                        System.out.println("4. Назад");
                        System.out.print("\nYour choice: ");
                        int billChoice = scanner.nextInt();
                        scanner.nextLine(); // Чтение лишнего символа новой строки

                        if (billChoice == 4) {
                            System.out.println();
                            break;
                        }
                        System.out.print("\nВведите количество купюр:   ");
                        int count = scanner.nextInt();
                        scanner.nextLine(); // Чтение лишнего символа новой строки

                        switch (billChoice) {
                            case 1:
                                if (totalBalance() + count * 20 <= limitATM) {
                                    banknotesNominalTwenty += count;
                                    System.out.println("Добавлено " + count + " купюр номиналом 20 на общую сумму " + (count * 20));
                                } else {
                                    System.out.println("\nПревышен лимит банкомата!");
                                    System.out.println();
                                }
                                break;

                            case 2:
                                if (totalBalance() + count * 50 <= limitATM) {
                                    banknotesNominalFifty += count;
                                    System.out.println("Добавлено " + count + " купюр номиналом 50 на общую сумму " + (count * 50));
                                } else {
                                    System.out.println("\nПревышен лимит банкомата!");
                                }
                                break;

                            case 3:
                                if (totalBalance() + count * 100 <= limitATM) {
                                    banknotesNominalOneHundred += count;
                                    System.out.println("Добавлено " + count + " купюр номиналом 100 на общую сумму " + (count * 100));
                                } else {
                                    System.out.println("Превышен лимит банкомата!");
                                }
                                break;
                        }
                        printBalance();
                    }
                    break;

                case 3:
                    System.out.println("---------------------------------------");
                    return;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.\n");
            }
        }
    }

    public boolean withdraw(int amount) {

        int hundredsToWithdraw = Math.min(amount / 100, banknotesNominalOneHundred);
        amount -= hundredsToWithdraw * 100;

        int fiftiesToWithdraw = Math.min(amount / 50, banknotesNominalFifty);
        amount -= fiftiesToWithdraw * 50;

        int twentiesToWithdraw = Math.min(amount / 20, banknotesNominalTwenty);
        amount -= twentiesToWithdraw * 20;
        if (amount == 0) {
            banknotesNominalOneHundred -= hundredsToWithdraw;
            banknotesNominalFifty -= fiftiesToWithdraw;
            banknotesNominalTwenty -= twentiesToWithdraw;

            System.out.println("Выдано: " + hundredsToWithdraw + " купюр по 100, " + fiftiesToWithdraw +
                    " купюр по 50, " + twentiesToWithdraw + " купюр по 20.");
            return true;
        } else {
            System.out.println("\nНедостаточно купюр для выдачи запрашиваемой суммы.");
            return false;
        }
    }

    private int totalBalance() {
        return (banknotesNominalOneHundred * 100) + (banknotesNominalFifty * 50) + (banknotesNominalTwenty * 20);
    }

    public void printBalance() {
        System.out.println("---------------------------------------");
        System.out.println("Баланс банкомата:");
        System.out.println("Купюры номиналом 100: " + banknotesNominalOneHundred);
        System.out.println("Купюры номиналом 50: " + banknotesNominalFifty);
        System.out.println("Купюры номиналом 20: " + banknotesNominalTwenty);

        int totalBalance = (banknotesNominalOneHundred * 100) + (banknotesNominalFifty * 50) +
                (banknotesNominalTwenty * 20);
        System.out.println("Общая сумма: " + totalBalance);
        System.out.println("---------------------------------------");
    }

    public void getATMsOperation() {
        Scanner inputChoice = getScannerInput();

        int intChoice;
        do {
            System.out.println("\nSelect an action: ");
            System.out.println("1. Add money to an ATM");
            System.out.println("2. Withdraw money from an ATM");
            System.out.println("3. View the amount of funds in the ATM");
            System.out.println("4. Exit");
            System.out.print("\nВаш выбор: ");

            while (!inputChoice.hasNextInt()) {
                System.out.print("Неверный ввод. Пожалуйста, выберите 1-4: ");
                inputChoice.next();
            }
            intChoice = inputChoice.nextInt();

            if (intChoice < 1 || intChoice > 4) {
                System.out.println("Неверный выбор. Пожалуйста, выберите 1-4");
            } else {
                System.out.println();
                switch (intChoice) {
                    case 1:
                        addFunds();
                        getATMsOperation();
                        break;
                    case 2:
                        System.out.println("---------------------------------------");
                        System.out.print("Введите сумму для снятия: ");
                        int amount = inputChoice.nextInt();
                        boolean success = withdraw(amount);
                        if (success) {
                            System.out.println("Операция по снятию денег прошла успешно.");
                        } else {
                            System.out.println("Операция по снятию денег не удалась.");
                        }
                        printBalance();
                        getATMsOperation();
                        break;
                    case 3:
                        printBalance();
                        getATMsOperation();
                        break;
                    case 4:
                        return;
                }
            }
        } while (intChoice < 1 || intChoice > 4);
    }

    public Scanner getScannerInput() {
        return new Scanner(System.in);
    }
}
