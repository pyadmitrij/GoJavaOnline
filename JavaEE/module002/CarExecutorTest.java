package module002;

import module002.cars.MediumCar;
import module002.cars.SmallCar;
import module002.cars.SportCar;
import module002.cars.Transmission;
import module002.exceptions.ExecutorNoStartException;
import module002.interfaces.Executor;
import org.junit.Test;

public class CarExecutorTest {

    @Test
    public void test() {

        Executor carExecutor = new CarExecutor();

        carExecutor.addTask(new CarTask(new SmallCar("ZAZ", Transmission.MT)));
        carExecutor.addTask(new CarTask(new MediumCar("Subaru", Transmission.AT)));
        carExecutor.addTask(new CarTask(new SportCar("Ferrari", Transmission.MT)));

        carExecutor.addTask(new CarTask(new SmallCar("RENAULT", Transmission.MT)), new CarValidator());
        carExecutor.addTask(new CarTask(new SmallCar("FIAT", Transmission.AT)), new CarValidator());
        carExecutor.addTask(new CarTask(new MediumCar("FORD", Transmission.MT)), new CarValidator());
        carExecutor.addTask(new CarTask(new MediumCar("SUZUKI", Transmission.AT)), new CarValidator());
        carExecutor.addTask(new CarTask(new SportCar("Porsche", Transmission.MT)), new CarValidator());

        carExecutor.execute();

        System.out.println("Valid results:");
        try {
            for (Object car : carExecutor.getValidResults()){
                System.out.println(car.toString());
            }
        } catch (ExecutorNoStartException e) {
            e.printStackTrace();
        }

        System.out.println("Invalid results:");
        try {
            for (Object car : carExecutor.getInvalidResults()){
                System.out.println(car.toString());
            }
        } catch (ExecutorNoStartException e) {
            e.printStackTrace();
        }
    }
}
