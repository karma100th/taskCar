package taskCarProject.characteristics.enums;

import taskCarProject.interfaces.WheelSizeInter;

public enum WheelSizeFord implements WheelSizeInter {
    SIZE13(13), SIZE15(15);
    private int sizeValue;

    WheelSizeFord(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {
        return sizeValue;
    }
}
