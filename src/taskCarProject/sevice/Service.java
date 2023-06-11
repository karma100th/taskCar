package taskCarProject.sevice;

import taskCarProject.car.Car;
import taskCarProject.enums.Color;
import taskCarProject.enums.OptionalExtras;
import taskCarProject.enums.WheelSize;

public class Service {

    public Car paintingCar(Car car, Color color) {
        if (color != car.getColor()) {
            car.setColor(color);
        }
        return car;
    }

    public Car changeWheels(Car car, int wheelsSize) {
        if (wheelsSize != car.getWheelSize().getSizeValue()) {
            for (WheelSize wheelSizeElement : WheelSize.values()) {
                if (wheelSizeElement.getSizeValue() == wheelsSize) {
                    car.setWheelSize(wheelsSize);
                }
            }
        }
        return car;
    }

    public void addOptionalExtras(Car car, OptionalExtras optionalExtras) {
        byte repeatChecker = 0;
        OptionalExtras[] optionalExtrasNew = new OptionalExtras[car.getOptionalExtras().length + 1];
        for (int i = 0; i < car.getOptionalExtras().length; i++) {
            if (car.getOptionalExtras()[i] == optionalExtras) {
                repeatChecker++;
                break;
            }
            optionalExtrasNew[i] = car.getOptionalExtras()[i];
        }
        if (repeatChecker == 0) {
            optionalExtrasNew[optionalExtrasNew.length - 1] = optionalExtras;
            car.setOptionalExtras(optionalExtrasNew);
        }
    }


    public void deleteOptionalExtras(Car car, OptionalExtras delOptionalExtras) {
        if (car.getOptionalExtras().length == 1 && car.getOptionalExtras()[0] == delOptionalExtras) {
            car.setOptionalExtras(new OptionalExtras[0]);
            return;
        }
        OptionalExtras[] optionalExtrasNew = new OptionalExtras[car.getOptionalExtras().length - 1];
        for (int i = 0, j = 0; i < car.getOptionalExtras().length; i++, j++) {
            if (delOptionalExtras != car.getOptionalExtras()[i]) {
                optionalExtrasNew[j] = car.getOptionalExtras()[i];
            } else {
                j--;
            }
        }
        car.setOptionalExtras(optionalExtrasNew);
    }

    public Car addOptions(Car car, OptionalExtras[] optionalExtras) {
        for (OptionalExtras optionalExtrasElement : optionalExtras) {
            addOptionalExtras(car, optionalExtrasElement);
        }
        return car;
    }

    public Car delOptions(Car car, OptionalExtras[] delOptionalExtras) {
        for (OptionalExtras optionalExtrasElement : delOptionalExtras) {
            deleteOptionalExtras(car, optionalExtrasElement);
        }
        return car;
    }

    public Car changeOptions(Car car, OptionalExtras[] optionalExtras) {
        car.setOptionalExtras(optionalExtras);
        return car;
    }

}
