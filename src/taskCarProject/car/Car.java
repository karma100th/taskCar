package taskCarProject.car;

import taskCarProject.characteristics.options.DopOptions;
import taskCarProject.interfaces.*;
import java.util.*;

public abstract class Car {
    private ColorsInter color;
    private final ModelInter model;
    private final int yearProduction;
    private WheelSizeInter wheelSize;
    private final EngineDisplacementInter engineDisplacement;
    private Set<OptionalExtrasInter> optionalExtras;
    private DopOptions dopOptions;


    public Car(ModelInter model, ColorsInter color, int yearProduction, WheelSizeInter wheelSize,
               EngineDisplacementInter engineDisplacement, OptionalExtrasInter[] optionalExtras, DopOptions dopOptions) {
        this.color = color;
        this.model = model;
        this.yearProduction = yearProduction;
        this.wheelSize = wheelSize;
        this.engineDisplacement = engineDisplacement;
        this.optionalExtras = new HashSet<>(Arrays.asList(optionalExtras));
        this.dopOptions = dopOptions;
    }

    public Car(ModelInter model, ColorsInter color, int yearProduction, WheelSizeInter wheelSize,
               EngineDisplacementInter engineDisplacement, DopOptions dopOptions) {
        this.color = color;
        this.model = model;
        this.yearProduction = yearProduction;
        this.wheelSize = wheelSize;
        this.engineDisplacement = engineDisplacement;
        optionalExtras = new HashSet<>();
        this.dopOptions = dopOptions;
    }

    public void setColor(ColorsInter color) {
        if (color != this.color) {
            this.color = color;
        }
    }

    public void setWheelSize(WheelSizeInter wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Set<OptionalExtrasInter> getOptionalExtras() {
        return optionalExtras;
    }

    public void setOptionalExtras(Set<OptionalExtrasInter> optionalExtras) {
        this.optionalExtras = optionalExtras;
    }

    public void setDopOptions(DopOptions dopOptions) {
        this.dopOptions = dopOptions;
    }

    public ColorsInter getColor() {
        return color;
    }

    public ModelInter getModel() {
        return model;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public WheelSizeInter getWheelSize() {
        return wheelSize;
    }

    public EngineDisplacementInter getEngineDisplacement() {
        return engineDisplacement;
    }

    public DopOptions getDopOptions() {
        return dopOptions;
    }

    //print information about car
    @Override
    public String toString() {
        String optionalExtrasChecker;
        if (optionalExtras.size() == 0) {
            optionalExtrasChecker = " отсутствуют";
        } else {
            optionalExtrasChecker = optionalExtras
                    .stream()
                    .map(OptionalExtrasInter::getNameOption)
                    .toList()
                    .toString();
        }
        return "Car{" +
                "Модель: " + model +
                ", Цвет кузова: " + color +
                ", Год выпуска: " + yearProduction +
                ", Размер дисков: " + wheelSize.getSizeValue() +
                ", Обьем двигателя: " + engineDisplacement.getVolumeValue() +
                ", Дополнительные опции:" + optionalExtrasChecker +
                dopOptions.toString();
    }

    //equals for stock
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearProduction == car.yearProduction && color == car.color && model == car.model &&
                wheelSize == car.wheelSize && engineDisplacement == car.engineDisplacement &&
                Objects.equals(optionalExtras, car.optionalExtras);
    }
}
