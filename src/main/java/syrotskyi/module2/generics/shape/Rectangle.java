package syrotskyi.module2.generics.shape;

public class Rectangle extends Shape {
    private int sideA;
    private int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public void calculateSquare() {
        square = sideA * sideB;
    }
}
