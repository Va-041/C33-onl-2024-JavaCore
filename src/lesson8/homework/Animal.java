package lesson8.homework;

import java.util.Scanner;

abstract class Animal {
    String name;
    String color;
    int age;
    String gender;

    public Animal(String name, String color, int age, String gender) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = gender;
    }

    public String getAnimalType() {
        if (this instanceof Tiger) {
            return "Tiger";
        } else if (this instanceof Dog) {
            return "Dog";
        } else if (this instanceof Rabbit) {
            return "Rabbit";
        } else {
            return "Unknow animal";
        }
    }

    public void getVoice() {
    }

    public void getFood() {
        Scanner inputChoice = getScannerInput();
        int choice;

        do {
            String[] Food = {"Meat", "Fish", "Grass", "Roots"};

            System.out.println("What kind of food do you want to feed " + getAnimalType() + "?");
            System.out.println("1. " + Food[0]);
            System.out.println("2. " + Food[1]);
            System.out.println("3. " + Food[2]);
            System.out.println("4. " + Food[3]);
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            while (!inputChoice.hasNextInt()) {
                System.out.print("Invalid input. Please choose 1-5: "); // проверка на ввод 1 5 а не других символов
                inputChoice.next();
            }
            choice = inputChoice.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose 1-5"); // проверка на ввод цифр от 1 до 5
            } else {

                String selectedFood = Food[choice - 1];
                feed(selectedFood);

                System.out.print("\nDo you want to feed this animal again? (y/n): ");
                String feedAgain = inputChoice.next();
                if (feedAgain.equalsIgnoreCase("Y") || feedAgain.equalsIgnoreCase("y")) {
                    getFood(); // повторный вызов метода для того же животного
                }
            }
        } while (choice < 1 || choice > 5);
    }

    public void feed(String food) {
        System.out.println(getAnimalType() + " is eating " + food);
    }

    @Override
    public String toString() {
        return "\n----------------------------------------------\n" +
                "\n\tAnimal: " + this.getAnimalType() +"\n" +
                "\tGender: " + this.gender + "\n" +
                "\tName: " + this.name + "\n" +
                "\tColor: " + this.color + "\n" +
                "\tAge (y.o.): " + this.age + "\n";
    }

    public Scanner getScannerInput() {
        return new Scanner(System.in);
    }

}
