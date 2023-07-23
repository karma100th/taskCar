package taskCarProject.sevices;

import taskCarProject.car.Audi;
import taskCarProject.car.Bmw;
import taskCarProject.car.Car;
import taskCarProject.car.Ford;
import taskCarProject.characteristics.enums.ColorAudi;
import taskCarProject.characteristics.enums.ColorBmw;
import taskCarProject.characteristics.enums.ColorFord;
import taskCarProject.exceptions.IllegalCharacteristicException;
import taskCarProject.interfaces.ColorsInter;

public class ServiceForPainting {
    public Car paintingCar(Car car, ColorsInter color) {
        if (car != null) {
            if (car instanceof Bmw && color instanceof ColorBmw && color != car.getColor()) {
                car.setColor(color);
                return car;
            }
            if (car instanceof Audi && color instanceof ColorAudi && color != car.getColor()) {
                car.setColor(color);
                return car;
            }
            if (car instanceof Ford && color instanceof ColorFord && color != car.getColor()) {
                car.setColor(color);
                return car;
            }
            throw new IllegalCharacteristicException("This color is not accessible to this car");
        }
        throw new NullPointerException("Car is null");
    }
}
