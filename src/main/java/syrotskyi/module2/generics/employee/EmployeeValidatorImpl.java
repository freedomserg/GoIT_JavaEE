package syrotskyi.module2.generics.employee;

import syrotskyi.module2.generics.tasksExecutorFramework.Validator;

public class EmployeeValidatorImpl implements Validator<Employee> {
    @Override
    public boolean isValid(Employee employee) {
        String name = employee.getName();
        double salary = employee.getMonthlySalary();
        if (name == null || name.equals("")) {
            return false;
        } else if (salary <= 0 || salary > 2000) {
            return false;
        }

        return true;
    }
}
