package lesson9.homework.taskTwo;

public class Circle extends Figure {

    double radius;
    double PI = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    double getSquare() {
        return PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * PI * radius;
    }
}
