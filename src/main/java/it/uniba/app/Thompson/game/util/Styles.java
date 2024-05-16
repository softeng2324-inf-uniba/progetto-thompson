package main.java.it.uniba.app.Thompson.game.util;
/**
 * << Util >>
 * Class for font constants.
 */
public final class Styles {
    /**
     * Style constructor.
     */
    private Styles() { }
    /**
     * @param style Style of the returning string
     * @return Return unicode style based off style parameter
     */
    public static String getStyleUnicode(final Style style) {
        switch (style) {
            case BOLD -> {
                return "\u001B[1m";
            }
            case ITALIC -> {
               return "\u001B[3m";
            }
            default -> {
                return "\u001B[0m";
            }
        }
    }
}
