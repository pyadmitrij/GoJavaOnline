package module002.exceptions;

public class ExecutorNoStartException extends Exception {

    private boolean execute;

    public ExecutorNoStartException(boolean execute) {
        this.execute = execute;
    }

    public boolean isExecute() {
        return execute;
    }
}
