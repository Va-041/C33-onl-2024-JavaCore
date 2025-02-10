package lesson15.homework.BasicTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskThree {

    private static List<Student> students = new ArrayList<>();

    public static void startTaskThree() {

        System.out.println("\n========== Task THREE ==========\n");

        getStudentCollection();
        //печать информации о всех студентах
        System.out.println("All students in the collection:");
        for (Student student : students) {
            System.out.println(student);
        }

        //удаление студентов со средним баллом < 3 и перевод остальных на следующий курс
        System.out.println("\nWe remove students with an average score of < 3...");
        removeLowAverageStudents(students);

        //печать студентов после удаления и перевода на другой курс
        System.out.println("\nStudents after removal and promotion:");
        for (Student student : students) {
            System.out.println(student);
        }

        getStudentsFromCourse();
    }

    public static void getStudentCollection() {

        students.add(new Student("Ivan Mitchkevich", "PO-8", 3, List.of(5, 4, 3, 2)));
        students.add(new Student("Marya Litvinovich", "PO-8", 3, List.of(4, 4, 5, 4)));
        students.add(new Student("Sergey Rubchenko", "PO-10", 1, List.of(3, 2, 3, 3)));
        students.add(new Student("Anna Saharuchik", "PO-10", 1, List.of(5, 5, 5, 4)));
        students.add(new Student("Alina Zabivnaya", "TUO-54", 2, List.of(5, 4, 4, 5)));
    }

    public static void removeLowAverageStudents(List<Student> students) {

        List<Student> toRemove = new ArrayList<>();
        for (Student student : students) {
            double average = 0;
            for (int mark : student.marks) {
                average += mark;
            }
            average /= student.marks.size();
            if (average < 3) {
                toRemove.add(student);
                System.out.println("Removing student: " + student.getName() + " with average score: " + average);
            } else {
                student.setCourse(student.getCourse() + 1);
            }
        }
        students.removeAll(toRemove);
    }


    public static void getStudentsFromCourse() {
        Scanner input = getInputScanner();
        System.out.print("\nEnter the course number:  ");

        int courseNumber = input.nextInt();

        printStudent(students, courseNumber);
    }

    public static void printStudent(List<Student> students, int course) {

        System.out.println();

        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Student name: " + student.getName() + "\t\tCourse: " + student.getCourse());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found in course " + course);
            getStudentsFromCourse();
        }

        getRepeatMessage();
    }

    public static void getRepeatMessage() {
        Scanner scanner = getInputScanner();
        char userInput;

        while (true) {
            System.out.print("\n\nWould you like to repeat it?   Enter Y or N:  ");
            userInput = scanner.next().charAt(0);

            if (userInput == 'Y' || userInput == 'y') {
                getStudentsFromCourse();
                return;
            } else if (userInput == 'N' || userInput == 'n') {
                System.out.println("\n\nExit from Task THREE...");
                break;
            } else {
                System.out.println("\nIncorrect input. Please enter Y or N.");
            }
        }
    }

    public static Scanner getInputScanner() {
        return new Scanner(System.in);
    }
}
