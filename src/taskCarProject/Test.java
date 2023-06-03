package taskCarProject;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Service service1 = new Service();
        AutoFactory autoFactory = new AutoFactory(new Model[]{Model.BMW, Model.GMC, Model.AUDI},
                new EngineDisplacement[]{EngineDisplacement.MEDIUM_LITERS, EngineDisplacement.SMALL_LITERS},
                new Color[]{Color.RED, Color.BLACK}, new WheelSize[]{WheelSize.SIZE14,WheelSize.SIZE13});
        Showroom showroom1 = new Showroom(autoFactory,service1);
        autoFactory.printFactoryCapabilities();
        Car car1 = showroom1.carOrder(autoFactory, new Car(Model.AUDI, Color.GREEN, 2000,
                WheelSize.SIZE15, EngineDisplacement.MEDIUM_LITERS));
        service1.paintingCar(car1, Color.RED);
        car1.printCarInformation();
        service1.changeWheels(car1, 13);
        car1.printCarInformation();
        
    }
}
