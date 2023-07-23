package taskCarProject.car;

import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptionsBmw;

public class Bmw extends Car {
    public Bmw(ModelBmw model, ColorBmw color, int yearProduction, WheelSizeBmw wheelSize,
               EngineDisplacementBmw engineDisplacement, OptionalExtrasBmw[] optionalExtras, DopOptionsBmw glassTinting) {
        super(model, color, yearProduction, wheelSize, engineDisplacement, optionalExtras, glassTinting);
    }

    public Bmw(ModelBmw model, ColorBmw color, int yearProduction, WheelSizeBmw wheelSize,
               EngineDisplacementBmw engineDisplacement, DopOptionsBmw glassTinting) {
        super(model, color, yearProduction, wheelSize, engineDisplacement, glassTinting);
    }
}
