package lesson8.homework;

public class Tiger extends PredatorAnimal {

    public Tiger(String name, String color, int age, String gender, boolean hasFur) {
        super(name, color, age, gender, hasFur);
    }

    @Override
    public void getVoice() {
        System.out.println("\t\tThe Tiger GROWLS!");
    }

    @Override
    public void getFood() {
        super.getFood();
    }

    @Override
    public void feed(String food) {
        if (food.equals("Meat") || food.equals("Fish")) {
            System.out.println("The Tiger is happily eating " + food + "!");
        } else {
            System.out.println("Tigers do not eat " + food + ". They prefer meat and fish!");
        }
    }
}
