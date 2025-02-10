package lesson15.homework.BasicTask;

import java.util.Scanner;

public class TaskTwo extends AnimalCollection {

    private static AnimalCollection animalCollection = new AnimalCollection();


    public static void startTaskTwo() {

        System.out.println("\n========== Task TWO ==========\n");
        getAnimalStartedKit();
        getMenu();
    }

    public static void getMenu() {

        Scanner inputChoice = getInputScanner();
        int choice;

        do {
            System.out.println("\n\t\t\tMenu\n");
            System.out.println("1. Add Animal");
            System.out.println("2. Delete Animal");
            System.out.println("3. Show All Animals");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");

            while (!inputChoice.hasNextInt()) {
                System.out.print("Invalid input. Please choose 1-4: ");
                inputChoice.next();
            }
            choice = inputChoice.nextInt();

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please choose 1-4");
            } else {
                System.out.println();
                switch (choice) {
                    case 1:
                        addAnimalInCollection();
                        break;
                    case 2:
                        removeAnimalInCollection();
                        break;
                    case 3:
                        animalCollection.displayAnimals();
                        break;
                    case 4:
                        System.out.println("\nExit from Task TWO...");
                        return;
                }
            }
        } while (true);
    }

    public static void getAnimalStartedKit() {
        animalCollection.addAnimal("Lion");
        animalCollection.addAnimal("Tiger");
        animalCollection.addAnimal("Bear");
        animalCollection.addAnimal("Elephant");
        animalCollection.addAnimal("Zebra");

        System.out.println("Animals have been added. Current Collection: ");
        animalCollection.displayAnimals();
    }

    public static void addAnimalInCollection() {

        Scanner input = getInputScanner();

        System.out.print("Enter the number of animals you want to add:  ");
        int numAnimals = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numAnimals; i++) {
            System.out.print("\nEnter the animal name:  ");
            String animal = input.nextLine();
            animalCollection.addAnimal(animal);
        }

        System.out.println("\nAnimals have been added. Current Collection: ");
        animalCollection.displayAnimals();
    }

    public static void removeAnimalInCollection() {
        animalCollection.displayAnimals();
        System.out.println("\nThe last animal in the list has been removed. Current Collection: ");
        animalCollection.removeAnimal();
        animalCollection.displayAnimals();
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }
}
