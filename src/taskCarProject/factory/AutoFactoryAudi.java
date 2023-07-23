package taskCarProject.factory;

import taskCarProject.car.Audi;
import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptions;
import taskCarProject.characteristics.options.DopOptionsAudi;
import taskCarProject.exceptions.IllegalCharacteristicException;

import java.time.LocalDate;
import java.util.Random;

import static java.util.Arrays.*;

public class AutoFactoryAudi extends AutoFactory {
    private static final Random RANDOM = new Random();

    public AutoFactoryAudi(ModelAudi[] models, EngineDisplacementAudi[] engineDisplacements,
                           ColorAudi[] colors, WheelSizeAudi[] wheelSizes, DopOptionsAudi[] dopOptionsAudi) {
        super(models, engineDisplacements, colors, wheelSizes, dopOptionsAudi);
        for (int i = 0; i < models.length; i++) {
            super.getStock().getCars().add(new Audi(models[i], colors[RANDOM.nextInt(colors.length)], LocalDate.now().getYear(),
                    wheelSizes[RANDOM.nextInt(wheelSizes.length)], engineDisplacements[RANDOM.nextInt(engineDisplacements.length)],
                    dopOptionsAudi[RANDOM.nextInt(dopOptionsAudi.length)]));
        }
    }

    //create a car for the salon
    public Audi createCar(ModelAudi model, ColorAudi color, int yearProduction, WheelSizeAudi wheelSize,
                          EngineDisplacementAudi engineDisplacement, DopOptionsAudi maxSpeed) {
        if (asList(colors).contains(color) && asList(wheelSizes).contains(wheelSize)
                && asList(models).contains(model) && asList(engineDisplacements).contains(engineDisplacement)
                && stream(this.dopOptions)
                .map(DopOptions::getValue)
                .toList()
                .contains(maxSpeed.getValue())) {
            Audi newCar = (Audi) super.createCar(model, color, yearProduction, wheelSize, engineDisplacement, maxSpeed);
            if (newCar != null) {
                return newCar;
            }
            return new Audi(model, color, yearProduction, wheelSize, engineDisplacement, maxSpeed);
        }
        throw new IllegalCharacteristicException("The required parts are out of stock");
    }

}
