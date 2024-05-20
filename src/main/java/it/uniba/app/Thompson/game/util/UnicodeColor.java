package it.uniba.app.Thompson.game.util;

/**
 * {@literal << Util >>}
 * Class to manage of the color constants in unicode.
 */
public final class UnicodeColor {

    /**
     * Constructor for the class UnicodeColor.
     */
    private UnicodeColor() { }

    /**
     * Method getColorUnicode.
     * @param color Color of the returning unicode
     * @return Returns unicode color based off color parameter
     */
    public static String getColorUnicode(final Color color) {
        switch (color) {
            case GREY -> {
                return "\u001B[90m";
            }
            case PINK -> {
                return "\u001B[38;5;206m";
            }
            case ORANGE -> {
                return "\u001B[38;5;208m";
            }
            case YELLOW -> {
                return "\u001B[33m";
            }
            case BLUE -> {
                return "\u001B[34m";
            }
            case RED -> {
                return "\u001B[31m";
            }
            default -> {
                return "\u001B[0m";
            }
        }
    }
}
