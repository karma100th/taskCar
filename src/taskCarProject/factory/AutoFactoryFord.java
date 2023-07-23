package taskCarProject.factory;

import taskCarProject.car.Ford;
import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptions;
import taskCarProject.characteristics.options.DopOptionsFord;
import taskCarProject.exceptions.IllegalCharacteristicException;

import java.time.LocalDate;
import java.util.Random;

import static java.util.Arrays.*;

public class AutoFactoryFord extends AutoFactory{
    private static final Random RANDOM = new Random();
    public AutoFactoryFord(ModelFord[] models, EngineDisplacementFord[] engineDisplacements, ColorFord[] colors,
                           WheelSizeFord[] wheelSizes, DopOptionsFord[] clearance) {
        super(models, engineDisplacements, colors, wheelSizes, clearance);
        for (int i = 0; i < models.length; i++) {
            super.getStock().getCars().add(new Ford(models[i], colors[RANDOM.nextInt(colors.length)], LocalDate.now().getYear(),
                    wheelSizes[RANDOM.nextInt(wheelSizes.length)], engineDisplacements[RANDOM.nextInt(engineDisplacements.length)],
                    clearance[RANDOM.nextInt(clearance.length)]));
        }
    }

    //create a car for the salon
    public Ford createCar(ModelFord model, ColorFord color, int yearProduction, WheelSizeFord wheelSize,
                         EngineDisplacementFord engineDisplacement, DopOptionsFord clearance) {
        if (asList(colors).contains(color) && asList(wheelSizes).contains(wheelSize)
                && asList(models).contains(model) && asList(engineDisplacements).contains(engineDisplacement)
                && stream(this.dopOptions)
                .map(DopOptions::getValue)
                .toList()
                .contains(clearance.getValue())) {
            Ford newCar = (Ford) super.createCar(model, color, yearProduction, wheelSize, engineDisplacement, clearance);
            if (newCar != null) {
                return newCar;
            }
            return new Ford(model, color, yearProduction, wheelSize, engineDisplacement, clearance);
        }
        throw new IllegalCharacteristicException("The required parts are out of stock");
    }
}
