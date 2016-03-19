package syrotskyi.module2.generics.shape;

import syrotskyi.module2.generics.tasksExecutorFramework.Task;

public class ShapeTaskImpl implements Task<Shape> {
    private Shape shape;

    public ShapeTaskImpl(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.calculateSquare();
    }

    @Override
    public Shape getResult() {
        return shape;
    }
}
