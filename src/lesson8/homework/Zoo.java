package lesson8.homework;

import java.util.Scanner;

public class Zoo {

    public static void main(String[] args) {
        makeZoo();
        forTaskWithAsterisk();
    }

    public static void makeZoo() {
        Animal[] animals = new Animal[] {
                new Tiger("Natalya", "Reddish-yellow with black stripes", 5, "Female", true),
                new Dog("Buran","Black with grey spots", 3, "Male", true),
                new Rabbit("Koko","White", 1, "Female", true),
        };

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.getVoice();
        }
        feedAnimal(animals);
    }

    public static void feedAnimal(Animal[] animals) {
        Scanner inputChoice = getScannerInput();
        int choice;

        do {
            System.out.println("\n\nDo you want to feed some animal?");
            System.out.println("1. Tiger");
            System.out.println("2. Dog");
            System.out.println("3. Rabbit");
            System.out.println("4. No, I don't want to feed anyone, let them starve. (хихи-хаха)");
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
                        animals[0].getFood();
                        System.out.println();
                        feedAnyAnimals(inputChoice, animals);
                        break;
                    case 2:
                        animals[1].getFood();
                        System.out.println();
                        feedAnyAnimals(inputChoice, animals);
                        break;
                    case 3:
                        animals[2].getFood();
                        System.out.println();
                        feedAnyAnimals(inputChoice, animals);
                        break;
                    case 4:
                        handleRefusalToFeed(inputChoice, animals);
                        return;
                }
            }
        } while (true);
    }

    public static void feedAnyAnimals(Scanner inputChoice, Animal[] animals) {
        System.out.print("Do you want to feed another animal? (y/n): ");
        String feedAnother = inputChoice.next();
        if (feedAnother.equalsIgnoreCase("N") || feedAnother.equalsIgnoreCase("n")) {
            forTaskWithAsterisk();
            System.exit(0);
        } else if (feedAnother.equalsIgnoreCase("Y") || feedAnother.equalsIgnoreCase("y")) {
            feedAnimal(animals);
        }
    }

    public static void handleRefusalToFeed(Scanner inputChoice, Animal[] animals) {
        System.out.println("How can you?! They're so cute, feed them!");
        System.out.println("1. Okaaaay, but only one!");
        System.out.println("2. NO! I won't feed anyone, they're evil.");
        System.out.print("\nEnter your choice: ");

        int choice;
        do {
            while (!inputChoice.hasNextInt()) {
                System.out.print("Invalid input. Please choose 1 or 2: ");
                inputChoice.next();
            }
            choice = inputChoice.nextInt();

            if (choice < 1 || choice > 2) {
                System.out.println("Invalid choice. Please choose 1 or 2");
            } else {
                switch (choice) {
                    case 1:
                        System.out.println("\nWhat kind of animal will we feed?");
                        System.out.println("1. Tiger");
                        System.out.println("2. Dog");
                        System.out.println("3. Rabbit");
                        System.out.println("4. I thought that I still don't want to feed anyone.");
                        System.out.print("\nEnter your choice: ");
                        int newChoice = inputChoice.nextInt();
                        if (newChoice == 4) {
                            System.exit(0);
                        } else if (newChoice >= 1 && newChoice <= 3) {
                            feedAnimal(animals);
                        } else {
                            System.out.println("Invalid choice. Please choose 1-4");
                        }
                        break;
                    case 2:
                        System.out.println(":(");
                        forTaskWithAsterisk();
                        System.exit(0);
                }
            }
        } while (choice < 1 || choice > 2);
    }

    public static void forTaskWithAsterisk() {
        System.out.println("\n============ This is task with asterisk ============");

        // задание со звёздочкой, делаю на примере котика, а не собачки, потому что лень дописывать в основную прогу))

        // 1) если я сделал конструктор класса Cat приватным то видим что не можем создать объект Cat в другом классе
        // Animal Barsik = new Cat("Barsik_krutoi", "Orange mandarinka", 5, "Muzjik", true);
        // 2) В классе Cat создал отдельный статический метод для создания экземпляра класса Cat, использую его(потому
        // что публик статики вызывать можно
        Cat Barsik = Cat.createBarsik("Barsik_krutoi", "Orange mandarinka", 5, "Muzjik", true);
        // 3) Вызываю паблик статик методы голоса и кушать, смотреть в классе Cat!
        System.out.println("\n\t------------\n\tVoice method\n\t------------\n");
        Cat.getBarsikVoice(Barsik);

        System.out.println("\n\n\t-----------\n\tFood method\n\t-----------\n");
        Cat.getBarsikFood(Barsik);
    }

    public static Scanner getScannerInput() {
        return new Scanner(System.in);
    }
}
