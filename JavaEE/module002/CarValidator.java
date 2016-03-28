package module002;

import module002.cars.Car;
import module002.cars.Transmission;
import module002.interfaces.Validator;

public class CarValidator implements Validator<Car> {

    @Override
    public boolean isValid(Car car) {
        return (car.getMaxSpeedKmh() >= 260 && car.getTransmissionType() == Transmission.AT);
    }

}
