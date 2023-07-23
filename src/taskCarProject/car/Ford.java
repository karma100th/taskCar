package taskCarProject.car;

import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptionsFord;

public class Ford extends Car {
    public Ford(ModelFord model, ColorFord color, int yearProduction, WheelSizeFord wheelSize,
                EngineDisplacementFord engineDisplacement, OptionalExtrasFord[] optionalExtras, DopOptionsFord clearance) {
        super(model, color, yearProduction, wheelSize, engineDisplacement, optionalExtras, clearance);
    }

    public Ford(ModelFord model, ColorFord color, int yearProduction, WheelSizeFord wheelSize,
                EngineDisplacementFord engineDisplacement, DopOptionsFord clearance) {
        super(model, color, yearProduction, wheelSize, engineDisplacement, clearance);
    }
}
