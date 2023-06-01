package taskCarProject;

public enum EngineDisplacement {
    MICRO_LITERS(1.1), SMALL_LITERS(1.7),
    MEDIUM_LITERS(3.5), LARGE_CAPACITY_LITERS(6.8);
    private double volumeValue;

    EngineDisplacement(double volumeValue) {

        this.volumeValue = volumeValue;
    }

    public double getVolumeValue() {
        return volumeValue;
    }
}
