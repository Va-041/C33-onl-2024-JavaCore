package lesson15.homework.BasicTask;

import java.util.List;

public class Student {

    private String name;
    private String group;
    private int course;
    List<Integer> marks;

    public Student(String name, String group, int course, List<Integer> marks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "\nStudent: " + "\n" +
                "\tName: " + this.name + "\n" +
                "\tGroup: " + this.group + "\n" +
                "\tCourse: " + this.course + "\n" +
                "\tMarks: " + marks.toString().replace("[", "").replace("]", "");
    }
}
