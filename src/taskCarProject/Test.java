package taskCarProject;

import java.lang.reflect.Array;

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car(Color.GREEN, Model.AUDI, 1998, WheelSize.SIZE13, EngineDisplacement.MEDIUM_LITERS);
        car1.printCarInformation();
        Service.paintingCar(car1, "blue");
        car1.printCarInformation();
        Service.addOptions(car1,new OptionalExtras[]{OptionalExtras.WINCH, OptionalExtras.ROCKET_BOOSTER,OptionalExtras.CRUISE_CONTROL});
        car1.printCarInformation();
        Service.delOptions(car1, new OptionalExtras[]{OptionalExtras.WINCH, OptionalExtras.ROCKET_BOOSTER});
        car1.printCarInformation();
    }
}
