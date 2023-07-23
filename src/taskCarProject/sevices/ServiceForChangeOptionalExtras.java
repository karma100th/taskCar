package taskCarProject.sevices;

import taskCarProject.car.Audi;
import taskCarProject.car.Bmw;
import taskCarProject.car.Car;
import taskCarProject.car.Ford;
import taskCarProject.characteristics.enums.OptionalExtrasAudi;
import taskCarProject.characteristics.enums.OptionalExtrasBmw;
import taskCarProject.characteristics.enums.OptionalExtrasFord;
import taskCarProject.exceptions.IllegalCharacteristicException;
import taskCarProject.interfaces.OptionalExtrasInter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ServiceForChangeOptionalExtras<T> {
    public Car addOptionalExtras(Car car, OptionalExtrasInter optionalExtras) {
        if (car != null) {
            if (car instanceof Bmw && optionalExtras instanceof OptionalExtrasBmw) {
                car.getOptionalExtras().add(optionalExtras);
                return car;
            }
            if (car instanceof Audi && optionalExtras instanceof OptionalExtrasAudi) {
                car.getOptionalExtras().add(optionalExtras);
                return car;
            }
            if (car instanceof Ford && optionalExtras instanceof OptionalExtrasFord) {
                car.getOptionalExtras().add(optionalExtras);
                return car;
            }
            throw new IllegalCharacteristicException("This option cannot be fitted to this car");
        }
        throw new NullPointerException("Car is null");
    }

    public Car deleteOptionalExtras(Car car, OptionalExtrasInter delOptionalExtras) {
        if (car != null && car.getOptionalExtras().contains(delOptionalExtras)) {
            car.getOptionalExtras().remove(delOptionalExtras);
            return car;
        }
        throw new IllegalCharacteristicException("This option is not installed on this car or car is null");
    }

    public Car addOptions(Car car, OptionalExtrasInter[] optionalExtras) {
        if (car != null) {
            for (OptionalExtrasInter optionalExtrasInter : optionalExtras) {
                if (car instanceof Bmw && optionalExtrasInter instanceof OptionalExtrasBmw) {
                    car.getOptionalExtras().add(optionalExtrasInter);
                    return car;
                }
                if (car instanceof Audi && optionalExtrasInter instanceof OptionalExtrasAudi) {
                    car.getOptionalExtras().add(optionalExtrasInter);
                    return car;
                }
                if (car instanceof Ford && optionalExtrasInter instanceof OptionalExtrasFord) {
                    car.getOptionalExtras().add(optionalExtrasInter);
                    return car;
                }
            }
        }
        throw new NullPointerException("Car is null");
    }

    public Car delOptions(Car car, OptionalExtrasInter[] delOptionalExtras) {
        if (car != null) {
            for (OptionalExtrasInter optionalExtrasElement : delOptionalExtras) {
                deleteOptionalExtras(car, optionalExtrasElement);
            }
            return car;
        }
        throw new NullPointerException("Car is null");
    }

    public Bmw changeOptions(Bmw car, OptionalExtrasBmw[] optionalExtras) {
        if (car != null) {
            Set<OptionalExtrasInter> optionalExtrasInterSet = new HashSet<>(Arrays.asList(optionalExtras));
            car.setOptionalExtras(optionalExtrasInterSet);
            return car;
        }
        throw new NullPointerException("Car is null");
    }
    public Car changeOptions(Audi car, OptionalExtrasAudi[] optionalExtras) {
        if (car != null) {
            Set<OptionalExtrasInter> optionalExtrasInterSet = new HashSet<>(Arrays.asList(optionalExtras));
            car.setOptionalExtras(optionalExtrasInterSet);
            return car;
        }
        throw new NullPointerException("Car is null");
    }
    public Car changeOptions(Ford car, OptionalExtrasFord[] optionalExtras) {
        if (car != null) {
            Set<OptionalExtrasInter> optionalExtrasInterSet = new HashSet<>(Arrays.asList(optionalExtras));
            car.setOptionalExtras(optionalExtrasInterSet);
            return car;
        }
        throw new NullPointerException("Car is null");
    }
}
