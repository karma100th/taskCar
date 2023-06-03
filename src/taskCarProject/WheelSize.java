package taskCarProject;

public enum WheelSize {
    SIZE13(13), SIZE14(14), SIZE15(15), SIZE16(16),
    SIZE17(17), SIZE18(18), SIZE19(19);
    private int sizeValue;

    WheelSize(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    public static WheelSize getSizeByValue(int sizeValue) {
        for (WheelSize size : WheelSize.values()) {
            if (size.getSizeValue() == sizeValue) {
                return size;
            }
        }
        return null;
    }

    public static WheelSize setRandomWheelSize() {
        return WheelSize.values()[(int) Math.random() * (WheelSize.values().length - 1)];
    }

}
