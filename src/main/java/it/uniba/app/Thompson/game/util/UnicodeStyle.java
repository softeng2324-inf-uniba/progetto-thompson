package it.uniba.app.Thompson.game.util;

/**
 * << Util >>
 * Class for style constants.
 */
public final class UnicodeStyle {

    /**
     * Style constructor.
     */
    private UnicodeStyle() { }

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
            case UNDERLINE_CHAR -> {
                return "—";
            }
            default -> {
                return "\u001B[0m";
            }
        }
    }
}
