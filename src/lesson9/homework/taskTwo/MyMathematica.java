package lesson9.homework.taskTwo;

public class MyMathematica {

    public static void main(String[] args) {

        Figure[] figures = new Figure[5];

        figures[0] = new Circle(5.55);
        figures[1] = new Rectangle(5.12, 6.99);
        figures[2] = new Triangle(3.45,5.21,9.14,5.21,2);
        figures[3] = new Rectangle(8, 12);
        figures[4] = new Circle(32.45);

        double totalPerimeter = 0;
        double totalSquare = 0;
        for (Figure figure : figures) {
            totalPerimeter += figure.getPerimeter();
            totalSquare += figure.getSquare();

        }
        System.out.println("\n\nTotal perimeter from Figure array is: " + totalPerimeter);
        System.out.println("Total square from Figure array is: " + totalSquare);
    }
}
