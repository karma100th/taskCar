package taskCarProject;

public enum OptionalExtras {
    CRUISE_CONTROL("круиз-констроль"), WINCH("лебедка"),
    ALL_TERRAIN_TIRES("вездеходныйе шины"), ROCKET_BOOSTER("ракетный ускоритель");
    private String nameOption;

    OptionalExtras(String nameOption) {
        this.nameOption = nameOption;
    }

    public String getNameOption() {
        return nameOption;
    }
}
