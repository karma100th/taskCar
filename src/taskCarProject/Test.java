package taskCarProject;

import taskCarProject.car.Car;
import taskCarProject.enums.*;
import taskCarProject.factory.AutoFactory;
import taskCarProject.sevice.Service;
import taskCarProject.showroom.Showroom;

public class Test {
    public static void main(String[] args) {
        Service service1 = new Service();
        AutoFactory autoFactory = new AutoFactory(new Model[]{Model.BMW, Model.GMC, Model.AUDI},
                new EngineDisplacement[]{EngineDisplacement.MEDIUM_LITERS, EngineDisplacement.SMALL_LITERS},
                new Color[]{Color.RED, Color.BLACK}, new WheelSize[]{WheelSize.SIZE14, WheelSize.SIZE13});
        Showroom showroom1 = new Showroom(autoFactory, service1);
        autoFactory.printFactoryCapabilities();
        Car car1 = showroom1.carOrder(autoFactory, Model.AUDI, Color.GREEN, 2000,
                WheelSize.SIZE15, EngineDisplacement.MEDIUM_LITERS);
        service1.paintingCar(car1, Color.RED);

        service1.changeWheels(car1, 13);
        service1.addOptionalExtras(car1, OptionalExtras.CRUISE_CONTROL);
        service1.addOptionalExtras(car1, OptionalExtras.WINCH);
        System.out.println(car1.toString());
        Car car2 = autoFactory.createCar(Model.UAZ, Color.GREEN, 1998, WheelSize.SIZE13, EngineDisplacement.LARGE_CAPACITY_LITERS);
        System.out.println(car2.toString());
    }
}
