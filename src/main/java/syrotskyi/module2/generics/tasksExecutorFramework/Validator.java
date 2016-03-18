package syrotskyi.module2.generics.tasksExecutorFramework;

public interface Validator<T> {
    // Валидирует переданое значение
    boolean isValid(T result);
}
