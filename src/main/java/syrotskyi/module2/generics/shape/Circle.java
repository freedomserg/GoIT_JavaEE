package syrotskyi.module2.generics.shape;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void calculateSquare() {
        square = Math.PI * Math.pow(radius, 2);
        if (radius < 0) {
            square = - square;
        }
    }
}
