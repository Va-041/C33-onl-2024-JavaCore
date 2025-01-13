package lesson9.homework.taskTwo;

public class Rectangle extends Figure {
    double sideA;
    double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }


    @Override
    double getSquare() {
        return sideA * sideB;
    }

    @Override
    double getPerimeter() {
        return (sideA + sideB) * 2;
    }
}