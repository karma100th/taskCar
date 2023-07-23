package taskCarProject.characteristics.enums;

import taskCarProject.interfaces.EngineDisplacementInter;

public enum EngineDisplacementFord implements EngineDisplacementInter {
    MICRO_LITERS(1.3), SMALL_LITERS(1.8),
    MEDIUM_LITERS(3.7), LARGE_CAPACITY_LITERS(6.9);
    private double volumeValue;

    EngineDisplacementFord(double volumeValue) {

        this.volumeValue = volumeValue;
    }

    public double getVolumeValue() {
        return volumeValue;
    }
}
