package taskCarProject.factory;

import taskCarProject.car.Car;
import taskCarProject.enums.Color;
import taskCarProject.enums.EngineDisplacement;
import taskCarProject.enums.Model;
import taskCarProject.enums.WheelSize;

import java.time.LocalDate;
import java.util.Arrays;

public class AutoFactory {
    private Model[] models;
    private EngineDisplacement[] engineDisplacements;
    private Color[] colors;
    private WheelSize[] wheelSizes;
    private Stock stock;


    public AutoFactory(Model[] models, EngineDisplacement[] engineDisplacements, Color[] colors, WheelSize[] wheelSizes) {
        this.models = models;
        this.engineDisplacements = engineDisplacements;
        this.colors = colors;
        this.wheelSizes = wheelSizes;
        Car[] carsInStock = new Car[models.length];
        for (int i = 0; i < carsInStock.length; i++) {
            carsInStock[i] = new Car(models[i], Color.setRandomColor(), LocalDate.now().getYear(),
                    WheelSize.setRandomWheelSize(), EngineDisplacement.setRandomEngineDisplacement());
        }
        stock = new Stock(carsInStock);
    }

    //print possible models, colors, engine capacity, wheel sizes
    public void printFactoryCapabilities() {
        System.out.print("Завод может выпускать автомобили со следующими характеристиками:\n" +
                "Модель:    ");
        System.out.println(Arrays.toString(models));
        System.out.print("Цвета:    ");
        System.out.println(Arrays.toString(colors));
        System.out.print("Обьем двигателя:    ");
        System.out.println(Arrays.toString(EngineDisplacement.getEngineValueArray(engineDisplacements)));
        System.out.print("Размеры колес:    ");
        System.out.println(Arrays.toString(WheelSize.getSizeValueArray(wheelSizes)));
    }

    //create a car for the salon
    public Car createCar(Model model, Color color, int yearProduction, WheelSize wheelSize,
                         EngineDisplacement engineDisplacement) {
        Car carForSalon = new Car(null, null, 0, null, null);
        Model modelForSalon = null;
        Color colorForSalon = null;
        int yearProductionForSalon;
        EngineDisplacement engineDisplacementForSalon = null;
        WheelSize wheelSizeForSalon = null;
        for (Car carElement : stock.getCars()) {
            if (carElement.getModel() == model && carElement.getYearProduction() == yearProduction &&
                    carElement.getEngineDisplacement() == engineDisplacement && carElement.getWheelSize() == wheelSize
                    && carElement.getColor() == color) {
                carForSalon = carElement;
                stock.deleteCar(carElement);
                break;
            } else if (carElement.getModel() == model && carElement.getYearProduction() == yearProduction &&
                    carElement.getEngineDisplacement() == engineDisplacement && carElement.getWheelSize() == wheelSize) {
                carForSalon = carElement;
                carForSalon.setColor(color);
                stock.deleteCar(carElement);
            } else if (carElement.getModel() == model && carElement.getYearProduction() == yearProduction &&
                    carElement.getEngineDisplacement() == engineDisplacement && carElement.getColor() == color) {
                carForSalon = carElement;
                carForSalon.setWheelSize(wheelSize);
                stock.deleteCar(carElement);
            }
        }
        if (carForSalon.getModel() == null) {
            carForSalon = new Car(model, color, yearProduction, wheelSize, engineDisplacement);
        }
        return carForSalon;
    }
}
