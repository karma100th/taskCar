package taskCarProject;

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
    public Car carOrder(AutoFactory autoFactory, Car car) {
        return autoFactory.createCar(car);
    }

    //paint the car in the service
    public Car paintingCar(Service service, Car car, Color color) {
        return service.paintingCar(car, color);
    }
    public Car paintingCar(Service service, Car car, String color) {
        return service.paintingCar(car, color);
    }

    //change wheels in the service
    public  Car changeWheels( Service service, Car car, int wheelsSize) {
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
        return service.changeOptions(car, delOptions, addedOptions);
    }
}
