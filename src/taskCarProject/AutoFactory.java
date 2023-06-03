package taskCarProject;

import java.time.LocalDate;

public class AutoFactory {
    private Model[] models;
    private EngineDisplacement[] engineDisplacements;
    private Color[] colors;
    private WheelSize[] wheelSizes;
    private Car[] stock;

    public Car[] getStock() {
        return stock;
    }

    public AutoFactory(Model[] models, EngineDisplacement[] engineDisplacements, Color[] colors, WheelSize[] wheelSizes) {
        this.models = models;
        this.engineDisplacements = engineDisplacements;
        this.colors = colors;
        this.wheelSizes = wheelSizes;
        Model modelForLoop;
        stock = new Car[models.length];
        for (int i = 0; i < stock.length; i++) {
            stock[i] = new Car(models[i], Color.setRandomColor(), LocalDate.now().getYear(),
                    WheelSize.setRandomWheelSize(), EngineDisplacement.setRandomEngineDisplacement());
        }
    }
    //print possible models, colors, engine capacity, wheel sizes
    public void printFactoryCapabilities() {
        System.out.print("Завод может выпускать автомобили со следующими характеристиками:\n" +
                "Модель:    ");
        for (Model model : models) {
            System.out.print(model.name() + "\t");
        }
        System.out.print("\nЦвета:    ");
        for (Color color : colors) {
            System.out.print(color.name() + "\t");
        }
        System.out.print("\nОбьем двигателя:    ");
        for (EngineDisplacement engineDisplacement : engineDisplacements) {
            System.out.print(engineDisplacement.getVolumeValue() + "л\t");
        }
        System.out.print("\nРазмеры колес:    ");
        for (WheelSize wheelSize : wheelSizes) {
            System.out.print(wheelSize.getSizeValue() + "\"\t");
        }
    }
    //create a car for the salon
    public Car createCar (Car carForSalon) {
        for (Car carElement : stock) {
            if (carForSalon.equals(carForSalon)) {
                return carElement;
            }
        }
        Car newCar;
        Model modelForSalon = null;
        Color colorForSalon = null;
        EngineDisplacement engineDisplacementForSalon = null;
        WheelSize wheelSizeForSalon = null;

        for (Model modelElement : models) {
            if (carForSalon.getModel() == modelElement) {
                modelForSalon = modelElement;
                break;
            } else {
                modelForSalon = carForSalon.getModel();
            }
        }
        for (Color colorElement : colors) {
            if (carForSalon.getColor() == colorElement) {
                colorForSalon = colorElement;
                break;
            } else {
                colorForSalon = carForSalon.getColor();
            }
        }
        for (EngineDisplacement engineDisplacement : engineDisplacements) {
            if (carForSalon.getEngineDisplacement() == engineDisplacement) {
                engineDisplacementForSalon = engineDisplacement;
                break;
            } else {
                engineDisplacementForSalon = carForSalon.getEngineDisplacement();
            }
        }
        for (WheelSize wheelSizeElement : wheelSizes) {
            if (carForSalon.getWheelSize() == wheelSizeElement) {
                wheelSizeForSalon = wheelSizeElement;
                break;
            } else {
                wheelSizeForSalon = carForSalon.getWheelSize();
            }
        }
        return new Car(modelForSalon, colorForSalon, carForSalon.getYearProduction(), wheelSizeForSalon,
                engineDisplacementForSalon);
    }
}
