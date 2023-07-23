package taskCarProject.characteristics.enums;

import taskCarProject.interfaces.WheelSizeInter;

public enum WheelSizeAudi implements WheelSizeInter {
    SIZE16(16), SIZE17(17), SIZE18(18);
    private int sizeValue;

    WheelSizeAudi(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {
        return sizeValue;
    }
}
