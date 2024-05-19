package it.uniba.app.Thompson.game.util;

/**
 * {@literal << Util >>}
 * Class for the management of the style constants in unicode.
 */
public final class UnicodeStyle {

    /**
     * Constructor for the class UnicodeStyle.
     */
    private UnicodeStyle() { }

    /**
     * Method getStyleUnicode.
     * @param style Style of the returning unicode
     * @return Returns unicode style based off style parameter
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
