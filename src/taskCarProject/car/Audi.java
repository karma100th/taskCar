package taskCarProject.car;

import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptionsAudi;

public class Audi extends Car {
    public Audi(ModelAudi model, ColorAudi color, int yearProduction, WheelSizeAudi wheelSize,
                EngineDisplacementAudi engineDisplacement, OptionalExtrasAudi[] optionalExtras, DopOptionsAudi maxSpeed) {
        super(model, color, yearProduction, wheelSize, engineDisplacement, optionalExtras, maxSpeed);
    }

    public Audi(ModelAudi model, ColorAudi color, int yearProduction, WheelSizeAudi wheelSize,
                EngineDisplacementAudi engineDisplacement, DopOptionsAudi maxSpeed) {
        super(model, color, yearProduction, wheelSize, engineDisplacement, maxSpeed);
    }
}
