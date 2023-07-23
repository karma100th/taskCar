package taskCarProject.showroom;

import taskCarProject.car.Audi;
import taskCarProject.car.Bmw;
import taskCarProject.car.Car;
import taskCarProject.car.Ford;
import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptionsAudi;
import taskCarProject.characteristics.options.DopOptionsBmw;
import taskCarProject.characteristics.options.DopOptionsFord;
import taskCarProject.factory.AutoFactory;
import taskCarProject.factory.AutoFactoryAudi;
import taskCarProject.factory.AutoFactoryBmw;
import taskCarProject.factory.AutoFactoryFord;
import taskCarProject.interfaces.ColorsInter;
import taskCarProject.interfaces.OptionalExtrasInter;
import taskCarProject.interfaces.WheelSizeInter;
import taskCarProject.sevices.ServiceForChangeOptionalExtras;
import taskCarProject.sevices.ServiceForChangeWheels;
import taskCarProject.sevices.ServiceForPainting;

import java.util.Set;

public record Showroom(AutoFactory[] autoFactory, ServiceForChangeWheels serviceForChangeWheels,
                       ServiceForPainting serviceForPainting,
                       ServiceForChangeOptionalExtras serviceForChangeOptionalExtras) {

    //ordering a car from the factory
    public Bmw carOrder(AutoFactoryBmw autoFactory, ModelBmw model, ColorBmw color, int yearProduction, WheelSizeBmw wheelSize,
                        EngineDisplacementBmw engineDisplacement, DopOptionsBmw dopOptions) {
        return autoFactory.createCar(model, color, yearProduction, wheelSize, engineDisplacement, dopOptions);
    }

    public Audi carOrder(AutoFactoryAudi autoFactory, ModelAudi model, ColorAudi color, int yearProduction, WheelSizeAudi wheelSize,
                         EngineDisplacementAudi engineDisplacement, DopOptionsAudi dopOptions) {
        return autoFactory.createCar(model, color, yearProduction, wheelSize, engineDisplacement, dopOptions);
    }

    public Ford carOrder(AutoFactoryFord autoFactory, ModelFord model, ColorFord color, int yearProduction, WheelSizeFord wheelSize,
                         EngineDisplacementFord engineDisplacement, DopOptionsFord dopOptions) {
        return autoFactory.createCar(model, color, yearProduction, wheelSize, engineDisplacement, dopOptions);
    }

    //paint the car in the service
    public Car paintingCar(Car car, ColorsInter color) {
        return serviceForPainting.paintingCar(car, color);
    }

    //change wheels in the service
    public Car changeWheels(Car car, WheelSizeInter wheelsSize) {
        return serviceForChangeWheels.changeWheels(car, wheelsSize);
    }

    //add or remove additional options in the service
    public Car addOptions(Car car, OptionalExtrasInter[] optionalExtras) {
        return serviceForChangeOptionalExtras.addOptions(car, optionalExtras);
    }

    public Car deleteOptions(Car car, OptionalExtrasInter[] optionalExtras) {
        return serviceForChangeOptionalExtras.delOptions(car, optionalExtras);
    }

    public Car changeOptions(Bmw car, OptionalExtrasBmw[] addedOptions) {
        return serviceForChangeOptionalExtras.changeOptions(car, addedOptions);
    }

    public Car changeOptions(Audi car, OptionalExtrasAudi[] addedOptions) {
        return serviceForChangeOptionalExtras.changeOptions(car, addedOptions);
    }

    public Car changeOptions(Ford car, OptionalExtrasFord[] addedOptions) {
        return serviceForChangeOptionalExtras.changeOptions(car, addedOptions);
    }

    //print information from factory
    public void printInformationFromFactory(AutoFactory autoFactory) {
        autoFactory.printFactoryCapabilities();
    }
    public void printInformationFromAllFactories() {
        for (AutoFactory autoFactoryElement : autoFactory) {
            autoFactoryElement.printFactoryCapabilities();
        }
    }

    //print information about the availability of cars in all stocks of all factories of this showroom
    public void printInformationFromStocks() {
        for (AutoFactory autoFactoryElement : autoFactory) {
            autoFactoryElement.printCarsInStock();
        }
    }
}
