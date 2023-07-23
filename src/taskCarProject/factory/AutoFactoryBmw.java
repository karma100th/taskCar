package taskCarProject.factory;

import taskCarProject.car.Bmw;
import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptions;
import taskCarProject.characteristics.options.DopOptionsBmw;
import taskCarProject.exceptions.IllegalCharacteristicException;

import java.time.LocalDate;
import java.util.Random;

import static java.util.Arrays.*;

public class AutoFactoryBmw extends AutoFactory {
    private static final Random RANDOM = new Random();

    public AutoFactoryBmw(ModelBmw[] models, EngineDisplacementBmw[] engineDisplacements, ColorBmw[] colors,
                          WheelSizeBmw[] wheelSizes, DopOptionsBmw[] dopOptionsBmw) {
        super(models, engineDisplacements, colors, wheelSizes, dopOptionsBmw);
        for (int i = 0; i < models.length; i++) {
            super.getStock().getCars().add(new Bmw(models[i], colors[RANDOM.nextInt(colors.length)], LocalDate.now().getYear(),
                    wheelSizes[RANDOM.nextInt(wheelSizes.length)], engineDisplacements[RANDOM.nextInt(engineDisplacements.length)],
                    dopOptionsBmw[RANDOM.nextInt(dopOptionsBmw.length)]));
        }
    }

    //create a car for the salon
    public Bmw createCar(ModelBmw model, ColorBmw color, int yearProduction, WheelSizeBmw wheelSize,
                         EngineDisplacementBmw engineDisplacement, DopOptionsBmw glassTinting) {
        if (asList(colors).contains(color) && asList(wheelSizes).contains(wheelSize)
                && asList(models).contains(model) && asList(engineDisplacements).contains(engineDisplacement)
                && stream(this.dopOptions)
                .map(DopOptions::getValue)
                .toList()
                .contains(glassTinting.getValue())) {
            Bmw newCar = (Bmw) super.createCar(model, color, yearProduction, wheelSize, engineDisplacement, glassTinting);
            if (newCar != null) {
                return newCar;
            }
            return new Bmw(model, color, yearProduction, wheelSize, engineDisplacement, glassTinting);
        }
        throw new IllegalCharacteristicException("The required parts are out of stock");
    }

}
