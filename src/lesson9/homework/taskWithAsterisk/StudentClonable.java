package lesson9.homework.taskWithAsterisk;

public class StudentClonable implements Cloneable {

    int id = 0;
    String firstName;
    String lastName;
    int age;
    int course;

    StudentClonable(int id, String firstName, String lastName, int age, int course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }

    // создался сlone() который переопределяем
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {

        return "\n\tStudent: " + "\n" +
                "\t\tFirst name: "+ this.firstName + "\n" +
                "\t\tLast name: " + this.lastName + "\n" +
                "\t\tAge: " + this.age + "\n" +
                "\t\tCourse: " + this.course;
    }
}
