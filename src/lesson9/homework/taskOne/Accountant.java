package lesson9.homework.taskOne;

public class Accountant extends Employee implements Position {
    public Accountant(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void getPosition() {
        System.out.println("Accountant position");
    }
}
