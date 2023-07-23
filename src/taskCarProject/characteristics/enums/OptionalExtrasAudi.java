package taskCarProject.characteristics.enums;

import taskCarProject.interfaces.OptionalExtrasInter;

public enum OptionalExtrasAudi implements OptionalExtrasInter {
    CRUISE_CONTROL("круиз-констроль"), AUTOPILOT("автопилот");
    private final String nameOption;

    OptionalExtrasAudi(String nameOption) {
        this.nameOption = nameOption;
    }

    public String getNameOption() {
        return nameOption;
    }
}
