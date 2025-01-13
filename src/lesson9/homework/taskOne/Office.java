package lesson9.homework.taskOne;

public class Office {
    public static void main(String[] args) {
        createOffice();
    }

    public static void createOffice() {

        Employee director = new Director("Svetlana", "Nikolayevna", 44);
        Employee accountant = new Accountant("Ivan", "Ivanov", 25);
        Employee worker = new Worker("Daniil", "Stepanov", 39);

        System.out.println("\n-----------------------------");
        System.out.println(director);
        director.getPosition();

        System.out.println("\n-----------------------------");
        System.out.println(accountant);
        accountant.getPosition();
        System.out.println("\n-----------------------------");
        System.out.println(worker);
        worker.getPosition();
    }
}
