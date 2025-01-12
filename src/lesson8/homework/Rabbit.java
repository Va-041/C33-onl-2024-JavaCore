package lesson8.homework;

public class Rabbit extends HerbivoresAnimal {

    public Rabbit(String name, String color, int age, String gender, boolean hasFur) {
        super(name, color, age, gender, hasFur);
    }

    @Override
    public void getVoice() {
        System.out.println("\t\tThe Rabbit is SQUEAKING!");
    }

    @Override
    public void getFood() {
        super.getFood();
    }

    @Override
    public void feed(String food) {
        if (food.equals("Grass") || food.equals("Roots")) {
            System.out.println("The Rabbit is happily eating " + food + "!");
        } else {
            System.out.println("Rabbits do not eat " + food + ". They prefer grass and roots!");
        }
    }
}
