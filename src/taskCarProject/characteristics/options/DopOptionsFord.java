package taskCarProject.characteristics.options;

public class DopOptionsFord extends DopOptions {
    private Double clearance;

    public DopOptionsFord(Double clearance) {
        this.clearance = clearance;
    }

    @Override
    public Double getValue() {
        return clearance;
    }

    @Override
    public String toString() {
        return ", Дорожный просвет: " + clearance +
                '}';
    }
}
