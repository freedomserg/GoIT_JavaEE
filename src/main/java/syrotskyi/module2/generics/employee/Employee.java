package syrotskyi.module2.generics.employee;

public abstract class Employee {
    private String name;
    protected double monthlySalary;

    public Employee(String name) {
        this.name = name;
    }

    public abstract void calculateMonthlySalary();

    public String getName() {
        return name;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "name = '" + name + '\'' +
                ", monthlySalary = " + monthlySalary +
                '}';
    }
}
