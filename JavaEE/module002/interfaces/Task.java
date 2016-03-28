package module002.interfaces;

public interface Task<T> {

    void execute();

    T getResult();
}
