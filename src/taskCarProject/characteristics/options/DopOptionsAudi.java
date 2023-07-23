package taskCarProject.characteristics.options;

public class DopOptionsAudi extends DopOptions {
    private int maxSpeed;

    public DopOptionsAudi(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public Integer getValue() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return ", Максимальная скорость: " + maxSpeed +
                '}';
    }
}
