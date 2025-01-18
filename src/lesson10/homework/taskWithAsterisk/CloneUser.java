package lesson10.homework.taskWithAsterisk;

import java.util.Scanner;

public class CloneUser {

    public static void main(String[] args) {
        makeUsers();
    }

    public static void makeUsers() {
        User[] users = new User[] {
                new User(1, "Albinka2025", "12341234", "albinka2025@mail.ru"),
                new User(2, "bobik23", "bobik1111", "bobistar12@gmail.com"),
                new User(3, "krutoiperec228", "rozaReD12die", "charliedin@example.com"),
                new User(4, "HaKoJIeHu_HaKoJIeHu", "Im12Cool34eNd45", "davidcome@mail.ru"),
                new User(5, "EveElfie", "1Ov3-Ex-pi12-Ri3E-n0cE", "evelove@apple.com"),
                new User(6, "FreddiCpyGER", "dsad2111fod45-4545", "freddi@gmail.com"),
        };

        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("\n=========================================\n");

        startCloning(users);
    }

    public static void startCloning(User[] users) {

        Scanner input = getInputScanner();
        int choice;

        do {
            System.out.println("\nChoose a method for cloning: ");
            System.out.println("1. Shallow cloning");
            System.out.println("2. Deep cloning");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");

            while(!input.hasNextInt()) {
                System.out.print("Invalid input. Please choose 1-3: ");
                input.next();
            }
            choice = input.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid input. Please choose 1-3: ");
            } else {
                int inputID;
                Scanner inputClone = getInputScanner();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the ID of the user you want to clone: ");

                        while (!inputClone.hasNextInt()) {
                            System.out.print("Invalid input. Please repeat the input!");
                            inputClone.next();
                        }
                        inputID = inputClone.nextInt();

                        // проверка на допустимость значения Id
                        if (inputID < 1 || inputID > users.length) {
                            System.out.println("Invalid ID. Please enter a value between 1 and " + users.length + "!");
                            break;
                        }

                        User userClone = users[inputID - 1].shallowClone();
                        System.out.println("You have successfully cloned the user!");
                        System.out.println("\nOriginal user: " + users[inputID - 1]);
                        System.out.println("Cloned user: " + userClone);
                        System.out.println("Original user hashcode: " + users[inputID - 1].hashCode());
                        System.out.println("Cloned user hashcode: " + userClone.hashCode());

                        // проверка по ссылке
                        System.out.println("Are objects the same by reference? " + (users[inputID - 1] == userClone));

                        // иизменение клона и проверка, что оригинал не изменился
                        userClone.setNickname("ChangedNickname");
                        System.out.println("\nAfter modification:");
                        System.out.println("Original user: " + users[inputID - 1]);
                        System.out.println("Cloned user: " + userClone);

                        break;

                    case 2:
                        System.out.print("Enter the ID of the user you want to clone: ");

                        while (!inputClone.hasNextInt()) {
                            System.out.print("Invalid input. Please ");
                            inputClone.next();
                        }
                        inputID = inputClone.nextInt();

                        // проверка на допустимость значения ID
                        if (inputID < 1 || inputID > users.length) {
                            System.out.println("Invalid ID. Please enter a value between 1 and " + users.length + "!");
                            break;
                        }

                        User userDeepClone = users[inputID - 1].deepClone();
                        System.out.println("You have successfully cloned the user!");
                        System.out.println("\nOriginal user: " + users[inputID - 1]);
                        System.out.println("Deep cloned user: " + userDeepClone);
                        System.out.println("Original user hashcode: " + users[inputID - 1].hashCode());
                        System.out.println("Deep cloned user hashcode: " + userDeepClone.hashCode());

                        // проверка по ссылке
                        System.out.println("Are objects the same by reference? " + (users[inputID - 1] == userDeepClone));

                        // изменение глубокого клона и проверка, что оригинал не изменился
                        userDeepClone.setNickname("ChangedNickname");
                        System.out.println("\nAfter modification:");
                        System.out.println("Original user: " + users[inputID - 1]);
                        System.out.println("Deep cloned user: " + userDeepClone);

                        break;

                    case 3:
                        System.exit(0);
                }
            }
        } while(true);
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }
}
