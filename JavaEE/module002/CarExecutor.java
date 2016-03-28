package module002;

import module002.cars.Car;
import module002.exceptions.ExecutorBeganException;
import module002.exceptions.ExecutorNoStartException;
import module002.interfaces.Executor;
import module002.interfaces.Task;
import module002.interfaces.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarExecutor implements Executor<Car> {

    private List<Task<? extends Car>> taskList;
    private Map<Task<? extends Car>, Validator<Car>> taskMap;
    private List<Car> validResult;
    private List<Car> invalidResult;

    public CarExecutor() {
        this.taskList = new ArrayList<>();
        this.taskMap = new HashMap<>();
        validResult = new ArrayList<>();
        invalidResult = new ArrayList<>();
    }

    @Override
    public void addTask(Task<Car> task) throws ExecutorBeganException {
        taskList.add(task);
    }

    @Override
    public void addTask(Task<Car> task, Validator<Car> validator) throws ExecutorBeganException {
        taskMap.put(task, validator);
    }

    @Override
    public void execute() {
        for (Task<? extends Car> task : taskList) {
            task.execute();
            validResult.add(task.getResult());
        }

        for (Map.Entry<Task<? extends Car>, Validator<Car>> pair : taskMap.entrySet()) {
            Task task = pair.getKey();
            Validator validator = pair.getValue();

            task.execute();
            if (validator.isValid(task.getResult()))
                validResult.add((Car) task.getResult());
            else
                invalidResult.add((Car) task.getResult());
        }

    }

    @Override
    public List<Car> getValidResults() throws ExecutorNoStartException {
        return this.validResult;
    }

    @Override
    public List<Car> getInvalidResults() throws ExecutorNoStartException {
        return this.invalidResult;
    }
}
