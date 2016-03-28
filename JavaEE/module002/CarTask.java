package module002;

import module002.cars.Car;
import module002.cars.MediumCar;
import module002.cars.SmallCar;
import module002.cars.SportCar;
import module002.interfaces.Task;

public class CarTask implements Task<Car>{

    private Car car;

    public CarTask(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {

        if (car instanceof SmallCar){
            car.setMaxSpeedKmh(160);
        }
        else if (car instanceof MediumCar){
            car.setMaxSpeedKmh(260);
        }
        else if (car instanceof SportCar){
            car.setMaxSpeedKmh(360);
        }

    }

    @Override
    public Car getResult() {
        return car;
    }
}
