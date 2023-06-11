package taskCarProject.enums;

import java.util.Set;

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


    public static String[] getNameArray(OptionalExtras[] optionalExtras) {
        String[] arrayNames = new String[optionalExtras.length];
        for (int i = 0; i < arrayNames.length; i++) {
            arrayNames[i] = optionalExtras[i].nameOption;
        }
        return arrayNames;
    }

}
