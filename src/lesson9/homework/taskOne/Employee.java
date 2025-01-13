package lesson9.homework.taskOne;

public class Employee implements Position {

    private String name;
    private String surname;
    private int age;


    public Employee(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public void getPosition(){
    };

    @Override
    public String toString() {

        return "Employee:" + "\n" +
                "Name: " + this.name + "\n" +
                "Surname: " + this.surname + "\n" +
                "Age: " + this.age + "\n";
    }
}
