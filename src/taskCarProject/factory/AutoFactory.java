package taskCarProject.factory;

import taskCarProject.car.Car;
import taskCarProject.characteristics.options.DopOptions;
import taskCarProject.interfaces.ColorsInter;
import taskCarProject.interfaces.EngineDisplacementInter;
import taskCarProject.interfaces.ModelInter;
import taskCarProject.interfaces.WheelSizeInter;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AutoFactory {
    protected ModelInter[] models;
    protected EngineDisplacementInter[] engineDisplacements;
    protected ColorsInter[] colors;
    protected WheelSizeInter[] wheelSizes;
    protected DopOptions[] dopOptions;
    protected Stock stock;


    public AutoFactory(ModelInter[] models, EngineDisplacementInter[] engineDisplacements, ColorsInter[] colors,
                       WheelSizeInter[] wheelSizes, DopOptions[] dopOptions) {
        this.models = models;
        this.engineDisplacements = engineDisplacements;
        this.colors = colors;
        this.wheelSizes = wheelSizes;
        this.dopOptions = dopOptions;
        ArrayList<Car> carsInStock = new ArrayList<>();
        stock = new Stock(carsInStock);
    }

    protected Stock getStock() {
        return stock;
    }

    //print possible models, colors, engine capacity, wheel sizes
    public void printFactoryCapabilities() {
        System.out.printf(
                "Завод может выпускать автомобили со следующими характеристиками:\nМодель:    %s\n"
                        + "Цвета:    %s\n"
                        + "Обьем двигателя:    %s\n"
                        + "Размеры колес:    %s\n", Arrays.toString(models), Arrays.toString(colors),
                Arrays.stream(engineDisplacements)
                        .map(EngineDisplacementInter::getVolumeValue)
                        .collect(Collectors.toList()),
                Arrays.stream(wheelSizes)
                        .map(WheelSizeInter::getSizeValue)
                        .collect(Collectors.toList())
        );
    }

    //create a car for the salon
    protected Car createCar(ModelInter model, ColorsInter color, int yearProduction, WheelSizeInter wheelSize,
                            EngineDisplacementInter engineDisplacement, DopOptions dopOptions) {
        Car newCar = stock.getCarFromStock(model, color, yearProduction, wheelSize, engineDisplacement, dopOptions);
        if (newCar != null && Arrays.asList(colors).contains(color) && Arrays.asList(wheelSizes).contains(wheelSize)
                && Arrays.asList(this.dopOptions).contains(dopOptions)) {
            if (color != newCar.getColor()) {
                newCar.setColor(color);
            }
            if (wheelSize != newCar.getWheelSize()) {
                newCar.setWheelSize(wheelSize);
            }
            if (dopOptions.getValue() != newCar.getDopOptions().getValue()) {
                newCar.setDopOptions(dopOptions);
            }
            return newCar;
        }
        return null;
    }

    //create a cars in Stock
    public void printCarsInStock() {
        System.out.println(stock.toString());
    }
}
