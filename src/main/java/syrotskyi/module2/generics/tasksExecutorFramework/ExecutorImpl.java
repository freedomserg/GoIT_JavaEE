package syrotskyi.module2.generics.tasksExecutorFramework;

import syrotskyi.module2.generics.tasksExecutorFramework.exceptions.AllTasksWereExecutedException;
import syrotskyi.module2.generics.tasksExecutorFramework.exceptions.TasksAreNotExecutedException;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T> implements Executor<T> {
    private List<Task<? extends T>> tasks = new ArrayList<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();
    private Validator<T> validator;
    private boolean allTasksAreExecuted;

    @Override
    public void addTask(Task<? extends T> task) {
        verifyIfTasksAreNotExecuted();
        tasks.add(task);

    }

    private void verifyIfTasksAreNotExecuted() {
        if (allTasksAreExecuted) {
            throw new AllTasksWereExecutedException();
        }
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<T> validator) {
        verifyIfTasksAreNotExecuted();
        this.validator = validator;
        tasks.add(task);

    }

    @Override
    public void execute() {
        for (Task<? extends T> task : tasks) {
            task.execute();
            T item = task.getResult();

            if (validator.isValid(item)) {
                validResults.add(item);
            } else {
                invalidResults.add(item);
            }
        }

        allTasksAreExecuted = true;
    }

    @Override
    public List<T> getValidResults() {
        checkIfTasksAreExecuted();
        return validResults;
    }

    private void checkIfTasksAreExecuted() {
        if (!allTasksAreExecuted) {
            throw new TasksAreNotExecutedException();
        }
    }

    @Override
    public List<T> getInvalidResults() {
        checkIfTasksAreExecuted();
        return invalidResults;
    }
}
