package lesson7.homework.task.asterisk;

public class MyMainAsterisk {

    public static void main(String[] args) {

        Apple apple = new Apple();
        System.out.println("\nDefault color: "+ apple.getColor());

        apple.getNewColor("Red");
        System.out.println("\nNew color: "+ apple.getColor());
    }
}
