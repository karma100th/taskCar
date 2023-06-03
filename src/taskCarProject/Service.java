package taskCarProject;

public class Service {
    public Car paintingCar(Car car, Color color) {
        car.setColor(color);
        return null;
    }
    public Car paintingCar(Car car, String color) {
        car.setColor(color);
        return car;
    }
    public Car changeWheels(Car car, int wheelsSize) {
        car.setWheelSize(wheelsSize);
        return car;
    }
    public Car addOptions(Car car, OptionalExtras[] optionalExtras) {
        for (OptionalExtras optionalExtrasElement : optionalExtras) {
            car.addOptionalExtras(optionalExtrasElement);
        }
        return car;
    }
    public Car delOptions(Car car, OptionalExtras[] delOptionalExtras) {
        for (OptionalExtras optionalExtrasElement : delOptionalExtras) {
            car.deleteOptionalExtras(optionalExtrasElement);
        }
        return car;
    }
    public Car changeOptions(Car car, OptionalExtras[] delOptionalExtras, OptionalExtras[] newOptionalExtras) {
        for (OptionalExtras optionalExtrasElement : car.getOptionalExtras()) {
            for (OptionalExtras delOption : delOptionalExtras) {
                car.deleteOptionalExtras(delOption);
            }
            for (OptionalExtras newOption : newOptionalExtras) {
                car.addOptionalExtras(newOption);
            }
        }
        return car;
    }
}
