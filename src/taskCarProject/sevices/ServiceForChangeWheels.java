package taskCarProject.sevices;

import taskCarProject.car.Audi;
import taskCarProject.car.Bmw;
import taskCarProject.car.Car;
import taskCarProject.car.Ford;
import taskCarProject.characteristics.enums.WheelSizeAudi;
import taskCarProject.characteristics.enums.WheelSizeBmw;
import taskCarProject.characteristics.enums.WheelSizeFord;
import taskCarProject.exceptions.IllegalCharacteristicException;
import taskCarProject.interfaces.WheelSizeInter;

public class ServiceForChangeWheels {
    public Car changeWheels(Car car, WheelSizeInter wheelSize) {
        if (car != null) {
            if (car instanceof Bmw && wheelSize instanceof WheelSizeBmw) {
                car.setWheelSize(wheelSize);
                return car;
            }
            if (car instanceof Audi && wheelSize instanceof WheelSizeAudi) {
                car.setWheelSize(wheelSize);
                return car;
            }
            if (car instanceof Ford && wheelSize instanceof WheelSizeFord) {
                car.setWheelSize(wheelSize);
                return car;
            }
            throw new IllegalCharacteristicException("This wheel size is not accessible to this car");
        }
        throw new NullPointerException("Car is null!");
    }
}
