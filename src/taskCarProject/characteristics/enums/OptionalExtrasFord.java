package taskCarProject.characteristics.enums;

import taskCarProject.interfaces.OptionalExtrasInter;

public enum OptionalExtrasFord implements OptionalExtrasInter {
    REARVIEW_CAMERAS("камеры заднего вида"), ALARM_SYSTEM("охранная система");
    private final String nameOption;

    OptionalExtrasFord(String nameOption) {
        this.nameOption = nameOption;
    }

    public String getNameOption() {
        return nameOption;
    }
}
