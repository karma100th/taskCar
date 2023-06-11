package taskCarProject.showroom;

import taskCarProject.car.Car;
import taskCarProject.enums.*;
import taskCarProject.factory.AutoFactory;
import taskCarProject.sevice.Service;

public class Showroom {
    private AutoFactory autoFactory;
    private Service service;

    public Showroom(AutoFactory autoFactory, Service service) {
        this.autoFactory = autoFactory;
        this.service = service;
    }

    public AutoFactory getAutoFactory() {
        return autoFactory;
    }

    public Service getService() {
        return service;
    }

    //ordering a car from the factory
    public Car carOrder(AutoFactory autoFactory, Model model, Color color, int yearProduction, WheelSize wheelSize,
                        EngineDisplacement engineDisplacement) {
        return autoFactory.createCar(model, color, yearProduction, wheelSize, engineDisplacement);
    }

    //paint the car in the service
    public Car paintingCar(Service service, Car car, Color color) {
        return service.paintingCar(car, color);
    }


    //change wheels in the service
    public Car changeWheels(Service service, Car car, int wheelsSize) {
        return service.changeWheels(car, wheelsSize);
    }

    //add or remove additional options in the service
    public Car addOptions(Service service, Car car, OptionalExtras[] optionalExtras) {
        return service.addOptions(car, optionalExtras);
    }

    public Car deleteOptions(Service service, Car car, OptionalExtras[] optionalExtras) {
        return service.delOptions(car, optionalExtras);
    }

    public Car changeOptions(Service service, Car car, OptionalExtras[] delOptions, OptionalExtras[] addedOptions) {
        return service.changeOptions(car, addedOptions);
    }

    //print information from factory
    public void printInformationFromFactory(AutoFactory autoFactory) {
        autoFactory.printFactoryCapabilities();
    }
}
