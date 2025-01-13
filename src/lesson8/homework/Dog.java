package lesson8.homework;

public class Dog extends PredatorAnimal {

    public Dog(String name, String color, int age, String gender, boolean hasFur) {
        super(name, color, age, gender, hasFur);
    }

    @Override
    public void getVoice() {
        System.out.println("\t\tThe Dog BARKS!");
    }

    @Override
    public void getFood() {
        super.getFood();
    }

    @Override
    public void feed(String food) {
        if (food.equals("Meat") || food.equals("Fish")) {
            System.out.println("The Dog is happily eating " + food + "!");
        } else {
            System.out.println("Dogs do not eat " + food + ". They prefer meat and fish!");
        }
    }
}
