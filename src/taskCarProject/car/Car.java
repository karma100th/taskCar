package taskCarProject.car;

import taskCarProject.enums.*;

import java.util.Arrays;

public class Car {
    private Color color;
    private final Model model;
    private final int yearProduction;
    private WheelSize wheelSize;
    private final EngineDisplacement engineDisplacement;
    private OptionalExtras[] optionalExtras;

    public Car(Color color, Model model, int yearProduction, WheelSize wheelSize, EngineDisplacement engineDisplacement,
               OptionalExtras[] optionalExtras) {
        this.color = color;
        this.model = model;
        this.yearProduction = yearProduction;
        this.wheelSize = wheelSize;
        this.engineDisplacement = engineDisplacement;
        this.optionalExtras = optionalExtras;
    }

    public Car(Model model, Color color, int yearProduction, WheelSize wheelSize,
               EngineDisplacement engineDisplacement) {
        this.color = color;
        this.model = model;
        this.yearProduction = yearProduction;
        this.wheelSize = wheelSize;
        this.engineDisplacement = engineDisplacement;
        optionalExtras = new OptionalExtras[0];
    }

    public void setColor(Color color) {
        if (color != this.color) {
            this.color = color;
        }
    }

    public void setColor(String color) {
        if (!color.equalsIgnoreCase(this.color.toString())) {
            byte checker = 0;
            for (Color colorElement : Color.values()) {
                if (color.equalsIgnoreCase(colorElement.toString())) {
                    this.color = colorElement;
                    checker++;
                }
            }
            if (checker == 0) {
                System.out.println("Такого цвета нет в каталоге. В данный момент доступны следующие цвета: ");
                Color.printColors();
            }
        }
    }

    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setWheelSize(int size) {
        for (WheelSize wheelSizeElement : WheelSize.values()) {
            if (wheelSizeElement.getSizeValue() == size) {
                wheelSize = WheelSize.getSizeByValue(size);
            }
        }
    }

    public OptionalExtras[] getOptionalExtras() {
        return optionalExtras;
    }

    public void setOptionalExtras(OptionalExtras[] optionalExtras) {
        this.optionalExtras = optionalExtras;
    }

    public Color getColor() {
        return color;
    }

    public Model getModel() {
        return model;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public WheelSize getWheelSize() {
        return wheelSize;
    }

    public EngineDisplacement getEngineDisplacement() {
        return engineDisplacement;
    }


    //print information about car

    @Override
    public String toString() {
        String optionalExtrasChecker;
        if (optionalExtras.length == 0) {
            optionalExtrasChecker = " отсутствуют";
        } else {
            optionalExtrasChecker = Arrays.toString(OptionalExtras.getNameArray(optionalExtras));
//            for (String nameOption : OptionalExtras.getNameArray(optionalExtras))
        }
        return "Car{" +
                "Модель: " + model +
                ", Цвет кузова: " + color +
                ", Год выпуска: " + yearProduction +
                ", Размер дисков: " + wheelSize.getSizeValue() +
                ", Обьем двигателя" + engineDisplacement.getVolumeValue() +
                ", Дополнительные опции:" + optionalExtrasChecker +
                '}';
    }

    //equals for stock
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearProduction == car.yearProduction && color == car.color && model == car.model && wheelSize == car.wheelSize &&
                engineDisplacement == car.engineDisplacement && Arrays.equals(optionalExtras, car.optionalExtras);
    }

}
