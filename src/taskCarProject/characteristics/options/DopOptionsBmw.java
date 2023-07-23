package taskCarProject.characteristics.options;

public class DopOptionsBmw extends DopOptions{
    private Boolean glassTinting;

    public DopOptionsBmw(Boolean glassTinting) {
        this.glassTinting = glassTinting;
    }

    @Override
    public Boolean getValue() {
        return glassTinting;
    }

    @Override
    public String toString() {
        return ", Тонировка стекл: " + (glassTinting ? "+" : "-") +
                '}';
    }
}
