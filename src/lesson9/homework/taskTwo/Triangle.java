package lesson9.homework.taskTwo;

public class Triangle extends Figure {
    double sideA;
    double sideB;
    double sideC;
    double baseSide;
    double height;

    public Triangle(double sideA, double sideB, double sideC, double baseSide, double height) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.baseSide = baseSide;
        this.height = height;
    }


    @Override
    double getSquare() {
        return (baseSide * height) / 2;
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC;
    }
}
