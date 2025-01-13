package lesson9.homework.taskOne;

public class Director extends Employee implements Position {

    public Director(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void getPosition() {
        System.out.println("Director position");
    }
}
