package syrotskyi.module2.generics.shape;

public abstract class Shape {
    protected double square;

    public abstract void calculateSquare();

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "square = " + square +
                '}';
    }
}
