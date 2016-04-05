package syrotskyi.module2.generics.employee;

public class HourlyWageEmployee extends Employee {
    private double hourlyRate;
    private final static int HOURS_IN_WORKDAY = 8;
    private final static int WORKDAYS_IN_MONTH = 21;

    public HourlyWageEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculateMonthlySalary() {
        monthlySalary = hourlyRate * HOURS_IN_WORKDAY * WORKDAYS_IN_MONTH;
    }
}
