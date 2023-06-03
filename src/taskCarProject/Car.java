package taskCarProject;

import java.util.Arrays;

public class Car {
    private Color color;
    private Model model;
    private int yearProduction;
    private WheelSize wheelSize;
    private EngineDisplacement engineDisplacement;
    private OptionalExtras[] optionalExtras;

    public Car(Model model, Color color, int yearProduction, WheelSize wheelSize,
               EngineDisplacement engineDisplacement, OptionalExtras[] optionalExtras) {
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
        if (wheelSize != this.wheelSize) {
            this.wheelSize = wheelSize;
        }
    }

    public void setWheelSize(int size) {
        if (size != wheelSize.getSizeValue()) {
            for (WheelSize wheelSizeElement : WheelSize.values()) {
                if (wheelSizeElement.getSizeValue() == size) {
                    wheelSize = WheelSize.getSizeByValue(size);
                }
            }
        }
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

    public OptionalExtras[] getOptionalExtras() {
        return optionalExtras;
    }

    //method for adding optional extras
    public void addOptionalExtras(OptionalExtras optionalExtras) {
        if (this.optionalExtras == null) {
            this.optionalExtras = new OptionalExtras[1];
            this.optionalExtras[0] = optionalExtras;
        } else {
            byte repeatChecker = 0;
            OptionalExtras[] optionalExtrasNew = new OptionalExtras[this.optionalExtras.length + 1];
            for (int i = 0; i < this.optionalExtras.length; i++) {
                if (this.optionalExtras[i] == optionalExtras) {
                    repeatChecker++;
                    break;
                }
                optionalExtrasNew[i] = this.optionalExtras[i];
            }
            if (repeatChecker == 0) {
                optionalExtrasNew[optionalExtrasNew.length - 1] = optionalExtras;
                this.optionalExtras = optionalExtrasNew;
            }
        }

    }

    //method for adding optional extras учесть добавление нескольких похиций сразу или удаление нескольких
    public void deleteOptionalExtras(OptionalExtras delOptionalExtras) {
        if (optionalExtras == null) {
            return;
        }
        if (optionalExtras.length == 1 && optionalExtras[0] == delOptionalExtras) {
            optionalExtras = null;
            return;
        }
        OptionalExtras[] optionalExtrasNew = new OptionalExtras[optionalExtras.length - 1];
        for (int i = 0, j = 0; i < optionalExtras.length; i++, j++) {
            if (delOptionalExtras != optionalExtras[i]) {
                optionalExtrasNew[j] = optionalExtras[i];
            } else {
                j--;
            }
        }
        optionalExtras = optionalExtrasNew;
    }

    //print information about car
    public void printCarInformation() {
        System.out.println("\nМодель:\t" + model.name() + "\nЦвет кузова:\t" + color +
                "\nОбъем двигателя:\t" + engineDisplacement.getVolumeValue() + " л\nРазмер колёс:\t" +
                wheelSize.getSizeValue() + "\""
        );
        if (optionalExtras != null) {
            System.out.print("Дополнительные опции:\t");
            for (OptionalExtras optionalExtrasElement : optionalExtras) {
                System.out.print(optionalExtrasElement.getNameOption() + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearProduction == car.yearProduction && color == car.color && model == car.model &&
                wheelSize == car.wheelSize && engineDisplacement == car.engineDisplacement &&
                Arrays.equals(optionalExtras, car.optionalExtras);
    }
}
