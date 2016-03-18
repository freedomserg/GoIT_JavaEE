package syrotskyi.module2.generics.employee;

public class Manager extends Employee {
    private int fixedMonthlyPayment;
    private int bonusInPercentsOfMonthlyPayment;

    public Manager(String name, int fixedMonthlyPayment, int bonusInPercentsOfMonthlyPayment) {
        super(name);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
        this.bonusInPercentsOfMonthlyPayment = bonusInPercentsOfMonthlyPayment;

    }

    @Override
    public void calculateMonthlySalary() {
        monthlySalary = fixedMonthlyPayment + fixedMonthlyPayment * bonusInPercentsOfMonthlyPayment / 100;
    }
}
