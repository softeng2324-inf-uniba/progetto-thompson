package main.java.it.uniba.app.Thompson.game.util;

/**
 * << Util >>
 * Class for color constants.
 */
public final class Colors {
    /**
     * Color constructor.
     */
    private Colors() { }

    /**
     * @param color
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
            default -> {
                return "";
            }
        }
    }
}
