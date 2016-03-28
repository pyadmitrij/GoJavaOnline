package module002.exceptions;

public class ExecutorBeganException extends RuntimeException {

    private boolean execute;

    public ExecutorBeganException(boolean execute) {
        this.execute = execute;
    }

    public boolean isExecute() {
        return execute;
    }
}
