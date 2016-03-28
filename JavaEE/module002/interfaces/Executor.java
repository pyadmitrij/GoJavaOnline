package module002.interfaces;

import module002.exceptions.ExecutorBeganException;
import module002.exceptions.ExecutorNoStartException;

import java.util.List;

public interface Executor<T> {

    void addTask(Task<T> task) throws ExecutorBeganException;

    void addTask(Task<T> task, Validator<T> validator) throws ExecutorBeganException;

    void execute();

    List<T> getValidResults() throws ExecutorNoStartException;

    List<T> getInvalidResults() throws ExecutorNoStartException;

}
