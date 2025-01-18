package lesson9.homework.taskWithAsterisk;

public class MyMain {

    public static void main(String[] args) {

        // создал объект типа Студент
        StudentClonable student1 = new StudentClonable(10,"Ivan","Svetlov",20,5);
        System.out.println(student1);
        System.out.println("\n-------------------------------------------");

        //клонируем объект типа Студент
        System.out.println("\n\tStudent with clonable:");
        StudentClonable studentClone = (StudentClonable)student1.clone();
        System.out.print(studentClone);
        System.out.println();
    }
}
