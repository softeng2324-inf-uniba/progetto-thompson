package it.uniba.app.Thompson.game.util;

/**
 * << Util >>
 * Class for color constants.
 */
public final class UnicodeColor {

    /**
     * Color constructor.
     */
    private UnicodeColor() { }

    /**
     * @param color Color of the returning string
     * @return Returns unicode of color parameter
     */
    public static String getUnicodeFromColor(final Color color) {
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
