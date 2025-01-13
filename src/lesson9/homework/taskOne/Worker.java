package lesson9.homework.taskOne;

public class Worker extends Employee implements Position {
    public Worker(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void getPosition() {
        System.out.println("Worker position");
    }
}
