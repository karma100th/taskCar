package taskCarProject;

public enum Color {
    RED, GREEN, YELLOW, WHITE, BLACK, BLUE;
    //method for displaying the color catalog
    public static void printColors() {
        for (Color color : Color.values()) {
            System.out.print(color.name() + "\t");
        }
    }
}
