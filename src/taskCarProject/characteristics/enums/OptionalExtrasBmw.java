package taskCarProject.characteristics.enums;

import taskCarProject.interfaces.OptionalExtrasInter;

public enum OptionalExtrasBmw implements OptionalExtrasInter {
    PARKING_SENSORS("парктроники"), LEATHER_INTERIOR("кожаный салон");
    private final String nameOption;

    OptionalExtrasBmw(String nameOption) {
        this.nameOption = nameOption;
    }

    public String getNameOption() {
        return nameOption;
    }
}
