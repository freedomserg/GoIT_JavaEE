package syrotskyi.module2.generics;

import org.junit.Assert;
import org.junit.Test;
import syrotskyi.module2.generics.employee.*;
import syrotskyi.module2.generics.shape.Circle;
import syrotskyi.module2.generics.shape.Rectangle;
import syrotskyi.module2.generics.shape.Shape;
import syrotskyi.module2.generics.shape.ShapeTaskImpl;
import syrotskyi.module2.generics.tasksExecutorFramework.Executor;
import syrotskyi.module2.generics.tasksExecutorFramework.ExecutorImpl;
import syrotskyi.module2.generics.tasksExecutorFramework.Task;

public class ExecutorImplTest {

    @Test
    public void testEmployeeExecutor() {
        Executor<Employee> employeeExecutor = new ExecutorImpl<>();
        Task<Employee> task1 = new EmployeeTaskImpl(new FixedPaymentEmployee("John", 700));
        Task<Employee> task2 = new EmployeeTaskImpl(new HourlyWageEmployee("Denis", 5));
        Task<Employee> task3 = new EmployeeTaskImpl(new Manager("Greg", 700, 25));
        Task<Employee> task4 = new EmployeeTaskImpl(new Manager("", 800, 15));
        Task<Employee> task5 = new EmployeeTaskImpl(new Manager("Clark", 1500, 50));
        Task<Employee> task6 = new EmployeeTaskImpl(new FixedPaymentEmployee("Ann", 750));

        employeeExecutor.addTask(task1);
        employeeExecutor.addTask(task2);
        employeeExecutor.addTask(task3, result -> result.getMonthlySalary() <= 900);
        employeeExecutor.addTask(task4);
        employeeExecutor.addTask(task5);
        employeeExecutor.addTask(task6);

        employeeExecutor.execute();

        Assert.assertEquals("Wrong number of valid results", 4, employeeExecutor.getValidResults().size());
        Assert.assertEquals("Wrong salary",  Double.valueOf(840.0),
                Double.valueOf(employeeExecutor.getValidResults().get(1).getMonthlySalary()));
    }

    @Test
    public void testShapeExecutor() {
        Executor<Shape> shapeExecutor = new ExecutorImpl<>();
        Task<Shape> task1 = new ShapeTaskImpl(new Circle(4));
        Task<Shape> task2 = new ShapeTaskImpl(new Circle(50));
        Task<Shape> task3 = new ShapeTaskImpl(new Rectangle(5, 15));
        Task<Shape> task4 = new ShapeTaskImpl(new Rectangle(2, 12));
        Task<Shape> task5 = new ShapeTaskImpl(new Rectangle(-1, 9));
        Task<Shape> task6 = new ShapeTaskImpl(new Circle(-5));

        shapeExecutor.addTask(task1);
        shapeExecutor.addTask(task2);
        shapeExecutor.addTask(task3, result -> result.getSquare() >= 0);
        shapeExecutor.addTask(task4);
        shapeExecutor.addTask(task5);
        shapeExecutor.addTask(task6);

        shapeExecutor.execute();

        Assert.assertEquals("Wrong number of invalid results", 2, shapeExecutor.getInvalidResults().size());
        Assert.assertEquals("Wrong square", Double.valueOf(24.0),
                Double.valueOf(shapeExecutor.getValidResults().get(3).getSquare()));
    }
}